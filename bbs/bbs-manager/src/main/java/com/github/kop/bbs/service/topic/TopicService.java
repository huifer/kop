package com.github.kop.bbs.service.topic;

import com.github.kop.bbs.module.req.topic.TopicCreateReq;

public interface TopicService {

  boolean create(TopicCreateReq req, Long userId);
}
