package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.score.ScoreTypeEnum;

/** 发帖事件 */
public class PushPostEvent extends PointEvent {

  public PushPostEvent(Long userId) {
    super(userId);
  }

  @Override
  public ScoreTypeEnum type() {
    return ScoreTypeEnum.PUSH_POINT;
  }
}
