package com.github.kop.bbs.module.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/** 点赞类型 1 点赞 2踩 */
@Getter
@AllArgsConstructor
public enum ThumbsTypeEnum {
  THUMBS(1, "点赞"),
  TREAD(2, "点踩"),
  ;

  private final int code;
  private final String name;
}
