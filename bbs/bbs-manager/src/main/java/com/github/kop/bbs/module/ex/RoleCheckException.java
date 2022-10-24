package com.github.kop.bbs.module.ex;

import com.github.kop.bbs.module.AppHttpCodeEnum;

/**
 * @auth ahxiaoqi
 * @desc 角色校验异常
 * @time 2022/8/27 17:18
 */
public class RoleCheckException extends NoceException {

  public RoleCheckException(String msg) {
    super(msg);
  }

  public RoleCheckException(String msg, Throwable e) {
    super(msg, e);
  }

  public RoleCheckException(String msg, int code) {
    super(msg, code);
  }

  public RoleCheckException(String msg, int code, Throwable e) {
    super(msg, code, e);
  }

  public RoleCheckException(AppHttpCodeEnum enums, String message) {
    super(enums, message);
  }

  public RoleCheckException(AppHttpCodeEnum enums) {
    super(enums);
  }
}
