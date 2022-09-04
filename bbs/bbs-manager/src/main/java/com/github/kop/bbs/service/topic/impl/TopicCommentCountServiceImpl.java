package com.github.kop.bbs.service.topic.impl;

import com.github.kop.bbs.module.bo.TopicCommentUpdateBo;
import com.github.kop.bbs.repo.TopicCommentCountRepository;
import org.springframework.stereotype.Service;
import com.github.kop.bbs.service.topic.TopicCommentCountService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopicCommentCountServiceImpl implements TopicCommentCountService {

    @Resource
    private TopicCommentCountRepository topicCommentCountRepository;


    /**
     * 批量更新评论数量
     * @param updateBoArrayList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCommentCount(List<TopicCommentUpdateBo> updateBoArrayList) {
        topicCommentCountRepository.updateCommentCount(updateBoArrayList);
    }
}

