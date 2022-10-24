package com.github.kop.bbs.event.invitation;

import com.github.kop.bbs.module.bo.InvitationAuditEventBo;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/** 帖子审核事件 */
@Getter
public class InvitationAudit extends ApplicationEvent {

  private final InvitationAuditEventBo invitationAuditEventBo;

  public InvitationAudit(InvitationAuditEventBo invitationAuditEventBo) {
    super(invitationAuditEventBo);
    this.invitationAuditEventBo = invitationAuditEventBo;
  }
}
