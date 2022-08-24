package com.github.kop.bbs.event.invitation;

import java.time.Clock;
import org.springframework.context.ApplicationEvent;

/**
 * 帖子创建完成事件
 */
public class InvitationCreated extends ApplicationEvent {

  public InvitationCreated(Long invitationId) {
    super(invitationId);
  }

}
