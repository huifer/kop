package com.github.kop.bbs.service.audit;

import com.github.kop.bbs.module.entity.Topic;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 话题审核服务
 *
 * @param <S> Topic
 */
@Service
public class TopicAuditServiceImpl<S> implements AuditService<Topic> {

  @Override
  public boolean audit(Long userId, Long sid, AuditStatusEnum auditStatusEnum, String note) {
    return false;
  }

  @Override
  public AuditTypeEnum type() {
    return AuditTypeEnum.TOPIC;
  }
}
