package com.github.kop.bbs.module.ex;

public enum ExceptionEnums {
  EXX(200),
  CONV_ENUM_EXCEPTION(10001),
  ;
  private final int code;

  ExceptionEnums(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
