package com.github.kop.bbs.service.topic.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.event.topic.TopicCreatedEvent;
import com.github.kop.bbs.module.entity.Topic;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;
import com.github.kop.bbs.module.enums.topic.TopicSortTypeEnum;
import com.github.kop.bbs.module.req.topic.TopicAuditReq;
import com.github.kop.bbs.module.req.topic.TopicCreateReq;
import com.github.kop.bbs.module.req.topic.TopicCustomerQueryReq;
import com.github.kop.bbs.module.req.topic.TopicQueryReq;
import com.github.kop.bbs.module.res.topic.TopicQueryResp;
import com.github.kop.bbs.repo.TopicRepository;
import com.github.kop.bbs.service.audit.AuditServiceFactory;
import com.github.kop.bbs.service.topic.TopicService;
import java.util.function.Function;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServiceImpl implements TopicService {

  @Autowired
  private TopicRepository repository;

  @Autowired
  private ApplicationEventPublisher eventPublisher;
  @Autowired
  private AuditServiceFactory auditServiceFactory;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(TopicCreateReq req, Long userId) {
    Topic topic = new Topic();
    topic.setTopicTitle(req.getTopicTitle());
    topic.setTopicContent(req.getTopicContent());
    topic.setTopicStatus(AuditStatusEnum.TO_AUDIT.getCode());
    topic.setCreateUserId(userId);
    boolean b = repository.create(topic) > 0;
    if (b) {
      eventPublisher.publishEvent(new TopicCreatedEvent(topic.getTopicId()));
    }
    return b;
  }

  @Override
  public IPage<TopicQueryResp> page(Long page, Long size, TopicQueryReq req) {
    IPage<Topic> topicIPage = this.repository.page(page, size, req);

    return topicIPage.convert(new Function<Topic, TopicQueryResp>() {
      @Override
      public TopicQueryResp apply(Topic topic) {
        TopicQueryResp topicQueryResp = new TopicQueryResp();
        topicQueryResp.setTopicId(topic.getTopicId());
        topicQueryResp.setTopicTitle(topic.getTopicTitle());
        topicQueryResp.setTopicContent(topic.getTopicContent());
        return topicQueryResp;
      }
    });
  }

  @Override
  public boolean audit(Long userId, TopicAuditReq req) {
    return auditServiceFactory.factory(AuditTypeEnum.TOPIC)
        .audit(userId, req.getTopicId(), AuditStatusEnum.conv(req.isPass()), req.getContext());
  }

  @Override
  public IPage<TopicQueryResp> pagePass(Long page, Long size, TopicCustomerQueryReq topicCustomerQueryReq) {
    IPage<Topic> topicIPage = this.repository.pagePass(page, size,topicCustomerQueryReq.getTopicTitle(),topicCustomerQueryReq.getTopicSortType());

    return topicIPage.convert(new Function<Topic, TopicQueryResp>() {
      @Override
      public TopicQueryResp apply(Topic topic) {
        TopicQueryResp topicQueryResp = new TopicQueryResp();
        topicQueryResp.setTopicId(topic.getTopicId());
        topicQueryResp.setTopicTitle(topic.getTopicTitle());
        topicQueryResp.setTopicContent(topic.getTopicContent());
        return topicQueryResp;
      }
    });
  }
}
