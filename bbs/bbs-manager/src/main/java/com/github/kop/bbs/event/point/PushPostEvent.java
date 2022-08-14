package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.PointTypeEnums;

/**
 * 发帖事件
 */
public class PushPostEvent extends PointEvent {

  @Override
  PointTypeEnums type() {
    return PointTypeEnums.PUSH_POINT;
  }
}
