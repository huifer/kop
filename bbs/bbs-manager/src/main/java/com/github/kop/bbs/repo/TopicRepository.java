package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Topic;
import com.github.kop.bbs.module.req.topic.TopicQueryReq;

public interface TopicRepository {

  int  create(Topic topic);

  /**
   * 分页查询通过审核的
   */
  IPage<Topic> pagePass(Long page, Long size);

  IPage<Topic> page(Long page, Long size, TopicQueryReq req);
}
