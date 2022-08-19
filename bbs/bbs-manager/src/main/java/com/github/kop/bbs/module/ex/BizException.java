package com.github.kop.bbs.module.ex;

public class BizException extends RuntimeException {

  protected Integer code;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public BizException(ExceptionEnums exceptionEnums) {
    this.code = exceptionEnums.getCode();
  }

}