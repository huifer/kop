package com.example.entertainment.module.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRoleEnums {

  /**
   * 普通消费者
   */
  ACCOUNT(1),
  /**
   * 商家
   */
  Merchant(2),
  /**
   * 超级管理员
   */
  ADMIN(999),

  ;
  private int code;

}
