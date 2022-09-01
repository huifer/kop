package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.score.ScoreTypeEnum;

/** 签到事件 */
public class SignInEvent extends PointEvent {

  public SignInEvent(Long userId) {
    super(userId);
  }

  @Override
  public ScoreTypeEnum type() {
    return ScoreTypeEnum.SIG_IN;
  }
}
