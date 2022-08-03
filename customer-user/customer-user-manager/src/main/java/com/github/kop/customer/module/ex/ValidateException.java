package com.github.kop.customer.module.ex;

import com.github.kop.customer.module.enums.AppHttpCodeEnum;

public class ValidateException extends NoceException {

  public ValidateException(String msg) {
    super(msg);
  }

  public ValidateException(String msg, Throwable e) {
    super(msg, e);
  }

  public ValidateException(String msg, int code) {
    super(msg, code);
  }

  public ValidateException(String msg, int code, Throwable e) {
    super(msg, code, e);
  }

  public ValidateException(AppHttpCodeEnum enums, String message) {
    super(enums, message);
  }

  public ValidateException(AppHttpCodeEnum enums) {
    super(enums);
  }
}
