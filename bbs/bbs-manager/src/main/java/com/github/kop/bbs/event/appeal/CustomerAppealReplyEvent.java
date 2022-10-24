package com.github.kop.bbs.event.appeal;

import com.github.kop.bbs.module.bo.CustomerAppealReplyBo;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/** 申诉回复事件 通知申诉人员查看 */
@Getter
public class CustomerAppealReplyEvent extends ApplicationEvent {

  private final CustomerAppealReplyBo customerAppealReplyBo;

  public CustomerAppealReplyEvent(CustomerAppealReplyBo customerAppealReplyBo) {
    super(customerAppealReplyBo);
    this.customerAppealReplyBo = customerAppealReplyBo;
  }
}
