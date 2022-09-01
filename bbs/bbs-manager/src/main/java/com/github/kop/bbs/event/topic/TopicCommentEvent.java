package com.github.kop.bbs.event.topic;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;


/**
 * @auth ahxiaoqi
 * @desc 话题评论事件
 * @time 2022/9/1 23:21
 */
@Getter
public class TopicCommentEvent extends ApplicationEvent {

    private final Long topicId;

    public TopicCommentEvent(Long topicId) {
        super(topicId);
        this.topicId = topicId;
    }
}
