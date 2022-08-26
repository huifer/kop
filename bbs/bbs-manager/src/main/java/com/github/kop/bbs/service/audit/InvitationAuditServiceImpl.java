package com.github.kop.bbs.service.audit;

import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 帖子审核服务
 *
 * @param <S> Invitation
 */
@Service
public class InvitationAuditServiceImpl<S> implements AuditService<Invitation> {

  @Override
  public boolean audit(Long userId, Long sid, AuditStatusEnum auditStatusEnum, String note) {
    return false;
  }

  @Override
  public AuditTypeEnum type() {
    return AuditTypeEnum.INVITATION;
  }
}
