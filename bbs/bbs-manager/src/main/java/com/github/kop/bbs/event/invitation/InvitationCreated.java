package com.github.kop.bbs.event.invitation;

import java.time.Clock;
import org.springframework.context.ApplicationEvent;

/**
 * 帖子创建完成事件
 * 1. 通知审核人员进行审核
 */
public class InvitationCreated extends ApplicationEvent {

  public InvitationCreated(Long invitationId) {
    super(invitationId);
  }

}
