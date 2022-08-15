package com.github.kop.bbs.module.enums;

// 增减类型  0 减少 1 增加
public enum ScoreOperationEnums {
  ADD(1, "增加"),
  SUB(0, "减少"),
  ;
  private final int code;
  private final String name;

  ScoreOperationEnums(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getCode() {
    return code;
  }
}
