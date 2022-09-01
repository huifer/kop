package com.github.kop.bbs.event.topic;

import com.github.kop.bbs.module.bo.TopicCommentUpdateBo;
import com.github.kop.bbs.service.topic.TopicCommentCountService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auth ahxiaoqi
 * @desc 话题评论后更新评论数
 * @time 2022/9/1 23:27
 */
@Slf4j
@Component
public class TopicCommentListener implements ApplicationListener<TopicCommentEvent> {

    private static final Long threshold = 100L;

    // 总和的阈值
    private static final Long sumThreshold = 1000L;

    // 目前的设计
    // map,评论数量到了设定的阈值之后进入提交队列,设置当前数量为当前值-进队列的值,小于0 则为0
    // 到设定时间或者队列的评论数量够了 进行更新

    // 记录评论数量的map
    private static final ConcurrentHashMap<Long,Long> commentCountMap = new ConcurrentHashMap<>();

    /**
     * 更新用的list里的和
     */
    private static Long sumCount = 0L;

    private static final ReentrantLock LOCK = new ReentrantLock();

    // 更新用的对象
    private static  List<TopicCommentUpdateBo> updateList = new ArrayList<>();

    // 插入的队列 ,应该不需要
    private static Queue<List<TopicCommentUpdateBo>> updateQueue = new ArrayDeque<>();

    @Resource
    private TopicCommentCountService topicCommentCountService;

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(@NotNull TopicCommentEvent event) {
        // 暂时进来就加锁
        LOCK.lock();
        try {
            Long merge = commentCountMap.merge(event.getTopicId(), 1L, Long::sum);
            // 大于阈值,添加到更新用的对象
            if (merge > threshold){
                updateList.add(TopicCommentUpdateBo.builder()
                        .topicId(event.getTopicId())
                        .commentCount(merge)
                        .build());
                sumCount += merge;
                if (sumCount >sumThreshold){
                    updateQueue.add(updateList);
                    updateList.clear();
                }
            }
        }catch (Exception e){
            log.info("评论计数事件发生错误",e);
        }finally {
            LOCK.unlock();
        }
        // TODO: 2022/9/2 去更新评论数量

    }


    public static void main(String[] args) {
        ConcurrentHashMap<Long,Long> commentCountMap = new ConcurrentHashMap<>();
        System.out.println(commentCountMap.merge(1L,89L, Long::sum));
        System.out.println(commentCountMap.merge(1L,1L, Long::sum));
    }
}
