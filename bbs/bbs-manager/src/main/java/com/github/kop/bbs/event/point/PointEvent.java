package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.PointTypeEnums;

/**
 * 积分事件
 */
public abstract class PointEvent {

  /**
   * 获得积分的人
   */
  private Long userId;
  abstract PointTypeEnums type();

}
