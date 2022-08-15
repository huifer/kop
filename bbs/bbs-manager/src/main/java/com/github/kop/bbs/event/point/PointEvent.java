package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.ScoreTypeEnums;

/**
 * 积分事件
 */
public abstract class PointEvent {

  /**
   * 获得积分的人
   */
  private final Long userId;

  public PointEvent(Long userId) {
    this.userId = userId;
  }

  public Long getUserId() {
    return userId;
  }

  public abstract ScoreTypeEnums type();

}
