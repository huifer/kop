package com.github.kop.bbs.module.enums.score;

// 增减类型  0 减少 1 增加
public enum ScoreOperationEnum {
  ADD(1, "增加"),
  SUB(0, "减少"),
  ;
  private final int code;
  private final String name;

  ScoreOperationEnum(int code, String name) {
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
