package com.github.kop.bbs.module.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageStatusEnum {
  READ(1,"已读"),
  NOT_READ(0,"未读"),

  ;
  private final int code;
  private final String name;
}
