package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.ScoreTypeEnums;

/** 签到事件 */
public class SignInEvent extends PointEvent {

  public SignInEvent(Long userId) {
    super(userId);
  }

  @Override
  public ScoreTypeEnums type() {
    return ScoreTypeEnums.SIG_IN;
  }
}
