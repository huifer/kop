package com.github.kop.bbs.module;

import lombok.Getter;

@Getter
public enum AppHttpCodeEnum {
  UPDATE_ERROR(3003, "更新异常"),
  UPDATE_ID_ERROR(3004, "更新时id必填"),
  ;

  int code;
  String msg;

  AppHttpCodeEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
