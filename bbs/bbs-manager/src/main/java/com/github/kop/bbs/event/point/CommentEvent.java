package com.github.kop.bbs.event.point;

import com.github.kop.bbs.module.enums.PointTypeEnums;

/**
 * 评论事件
 */
public class CommentEvent extends PointEvent {

  @Override
  PointTypeEnums type() {
    return PointTypeEnums.COMMENT;
  }
}
