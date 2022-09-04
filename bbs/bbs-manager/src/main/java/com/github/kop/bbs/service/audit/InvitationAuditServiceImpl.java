package com.github.kop.bbs.service.audit;

import com.github.kop.bbs.config.BbsConfiguration;
import com.github.kop.bbs.event.invitation.InvitationAudit;
import com.github.kop.bbs.module.bo.InvitationAuditEventBo;
import com.github.kop.bbs.module.entity.Invitation;
import com.github.kop.bbs.module.entity.InvitationAuditLog;
import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.enums.AuditStatusEnum;
import com.github.kop.bbs.module.enums.AuditTypeEnum;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.service.invitation.InvitationAuditLogService;
import com.github.kop.bbs.service.invitation.InvitationService;
import com.github.kop.bbs.service.user.MidUserRoleService;
import com.github.kop.bbs.service.user.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 帖子审核服务
 *
 * @param <S> Invitation
 */
@Service
public class InvitationAuditServiceImpl<S> implements AuditService<Invitation> {

  @Resource
  private ApplicationEventPublisher applicationEventPublisher;

  @Override
  public boolean audit(Long userId, Long sid, AuditStatusEnum auditStatusEnum, String note) {
    InvitationAuditEventBo eventBo = new  InvitationAuditEventBo();
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
