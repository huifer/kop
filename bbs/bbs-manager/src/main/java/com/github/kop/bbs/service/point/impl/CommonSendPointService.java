package com.github.kop.bbs.service.point.impl;

import com.github.kop.bbs.event.point.PointEvent;
import com.github.kop.bbs.service.point.SendPointService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 公共的积分发放类
 */
public abstract class CommonSendPointService implements SendPointService {

  @Override
  public boolean send(PointEvent event) {

    return false;
  }

  /**
   * 当前人是否超过最大限额
   *
   */
  protected abstract boolean exceededMax(Long userId);


}
