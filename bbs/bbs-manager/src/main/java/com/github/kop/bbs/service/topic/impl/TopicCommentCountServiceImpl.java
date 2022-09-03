package com.github.kop.bbs.service.topic.impl;

import com.github.kop.bbs.repo.TopicCommentCountRepository;
import org.springframework.stereotype.Service;
import com.github.kop.bbs.service.topic.TopicCommentCountService;

import javax.annotation.Resource;

@Service
public class TopicCommentCountServiceImpl implements TopicCommentCountService {

    @Resource
    private TopicCommentCountRepository topicCommentCountRepository;




}

