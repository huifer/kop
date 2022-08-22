package com.github.kop.bbs.service.topic.impl;

import com.github.kop.bbs.module.entity.Topic;
import com.github.kop.bbs.module.enums.TopicStatusEnum;
import com.github.kop.bbs.module.req.topic.TopicCreateReq;
import com.github.kop.bbs.repo.TopicRepository;
import com.github.kop.bbs.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {

  @Autowired
  private TopicRepository repository;

  @Override
  public boolean create(TopicCreateReq req, Long userId) {
    Topic topic = new Topic();
    topic.setTopicTitle(req.getTopicTitle());
    topic.setTopicContent(req.getTopicContent());
    topic.setTopicStatus(TopicStatusEnum.TO_AUDIT.getCode());
    topic.setCreateUserId(userId);
    return repository.create(topic) > 0;
  }
}
