package com.github.kop.bbs.module.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 申诉类别 1 账号申诉 2 帖子申诉
 */
@AllArgsConstructor
@Getter
public enum AppealTypeEnum {
  ACCOUNT(1,"账号申诉"),
  INVITATION(2,"帖子申诉")
  ;
  private final Integer code;

  private final String desc;
}
