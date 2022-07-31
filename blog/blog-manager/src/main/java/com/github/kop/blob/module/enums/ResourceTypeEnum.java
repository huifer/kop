package com.github.kop.blob.module.enums;

import lombok.Getter;

@Getter
public enum ResourceTypeEnum {
  MENU(0, "菜单"),
  BUTTON(1, "按钮"),
  API(2, "接口");

  private final int code;
  private final String name;

  ResourceTypeEnum(int code, String name) {
    this.code = code;
    this.name = name;
  }
}
