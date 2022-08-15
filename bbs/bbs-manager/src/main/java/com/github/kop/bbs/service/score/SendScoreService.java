package com.github.kop.bbs.service.score;

import com.github.kop.bbs.event.point.PointEvent;

/** 积分发放接口 */
public interface SendScoreService {

  /**
   * 发放积分
   *
   * @param event 积分事件
   * @return 发放成功失败
   */
  public boolean send(PointEvent event);
}
