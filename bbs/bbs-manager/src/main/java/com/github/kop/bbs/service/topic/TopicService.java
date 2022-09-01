package com.github.kop.bbs.service.topic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.topic.TopicAuditReq;
import com.github.kop.bbs.module.req.topic.TopicCreateReq;
import com.github.kop.bbs.module.req.topic.TopicCustomerQueryReq;
import com.github.kop.bbs.module.req.topic.TopicQueryReq;
import com.github.kop.bbs.module.res.topic.TopicQueryResp;

public interface TopicService {

  boolean create(TopicCreateReq req, Long userId);

  IPage<TopicQueryResp> page(Long page, Long size, TopicQueryReq req);

  IPage<TopicQueryResp> pagePass(Long page, Long size, TopicCustomerQueryReq topicCustomerQueryReq);

  boolean audit(Long userId, TopicAuditReq req);
}
