package com.github.kop.pm.module.enums;

public enum ProjectTaskType {
  SYS_BUG(1, "系统分发的BUG任务"),
  SYS_FEAT(2, "系统分发的功能任务"),
  CUS_BUG(3, "用户自己创建的BUG任务"),
  CUS_FEAT(4, "用户自己创建的功能任务"),
  ;

  private final int code;

  public int getCode() {
    return code;
  }

  private final String msg;

  ProjectTaskType(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

}
