package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.PointTypeEnums;

/**
 * 签到事件
 */
public class SignInEvent extends PointEvent {

  @Override
  PointTypeEnums type() {
    return PointTypeEnums.SIG_IN;

  }
}
