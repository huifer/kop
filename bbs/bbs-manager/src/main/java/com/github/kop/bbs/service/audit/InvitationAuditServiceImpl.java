package com.github.kop.bbs.service.audit;

import com.github.kop.bbs.module.bo.InvitationAuditEventBo;
import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;
import javax.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 帖子审核服务
 *
 * @param <S> Invitation
 */
@Service
public class InvitationAuditServiceImpl<S> implements AuditService<Invitation> {

  @Resource private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public boolean audit(Long userId, Long sid, AuditStatusEnum auditStatusEnum, String note) {
    InvitationAuditEventBo eventBo = new InvitationAuditEventBo();
    eventBo.setUserId(userId);
    eventBo.setSid(sid);
    eventBo.setAuditStatusEnum(auditStatusEnum);
    eventBo.setNote(note);
    applicationEventPublisher.publishEvent(eventBo);
    return true;
  }

  @Override
  public AuditTypeEnum type() {
    return AuditTypeEnum.INVITATION;
  }
}
