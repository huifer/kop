package com.github.kop.bbs.module.ex;

public enum ExceptionEnums {
  EXX(200),
  ;
  private final int code;

  ExceptionEnums(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
