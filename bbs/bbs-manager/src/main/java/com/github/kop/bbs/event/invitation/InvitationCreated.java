package com.github.kop.bbs.event.invitation;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 帖子创建完成事件
 * 1. 通知审核人员进行审核
 */
@Getter
public class InvitationCreated extends ApplicationEvent {

  private final Long invitationId;

  public InvitationCreated(Long invitationId) {
    super(invitationId);
    this.invitationId = invitationId;
  }

}
