package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.module.entity.Topic;
import com.github.kop.bbs.repo.TopicRepository;
import com.github.kop.bbs.repo.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepositoryImpl implements TopicRepository {

  @Autowired
  private TopicMapper topicMapper;

  @Override
  public int create(Topic topic) {
    return topicMapper.insert(topic);
  }

}
