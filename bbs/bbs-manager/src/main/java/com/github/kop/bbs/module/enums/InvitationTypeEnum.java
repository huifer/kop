package com.github.kop.bbs.module.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 帖子类型：1动态、2板块内容
 */
@AllArgsConstructor
@Getter
public enum InvitationTypeEnum {

  dynamic(1,"动态"),
  plate(2,"板块"),
  ;
  private final int code;
  private final String name;
}
