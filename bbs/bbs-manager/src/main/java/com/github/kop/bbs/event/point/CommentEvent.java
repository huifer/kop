package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.score.ScoreTypeEnum;

/** 评论事件 */
public class CommentEvent extends PointEvent {

  public CommentEvent(Long userId) {
    super(userId);
  }

  @Override
  public ScoreTypeEnum type() {
    return ScoreTypeEnum.COMMENT;
  }
}
