package com.github.kop.bbs.module.ex;

import com.github.kop.bbs.module.AppHttpCodeEnum;

public class NoceException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private AppHttpCodeEnum enums;
  private String msg;
  private int code = 3500;

  public NoceException(String msg) {
    super(msg);
    this.msg = msg;
  }

  public NoceException(String msg, Throwable e) {
    super(msg, e);
    this.msg = msg;
  }

  public NoceException(String msg, int code) {
    super(msg);
    this.msg = msg;
    this.code = code;
  }

  public NoceException(String msg, int code, Throwable e) {
    super(msg, e);
    this.msg = msg;
    this.code = code;
  }

  public NoceException(AppHttpCodeEnum enums, String message) {
    super(message);
    this.enums = enums;
    this.code = enums.getCode();
  }

  public NoceException(AppHttpCodeEnum enums) {

    this.enums = enums;
  }

  public AppHttpCodeEnum getEnums() {
    return enums;
  }

  public void setEnums(AppHttpCodeEnum enums) {
    this.enums = enums;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
