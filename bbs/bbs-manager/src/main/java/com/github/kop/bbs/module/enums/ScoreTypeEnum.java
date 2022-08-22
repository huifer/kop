package com.github.kop.bbs.module.enums;

public enum ScoreTypeEnum {
  /** 评论 */
  COMMENT(3, "评论积分"),
  /** 发帖 */
  PUSH_POINT(2, "发帖积分"),
  /** 签到 */
  SIG_IN(1, "签到积分"),
  ;
  private final int code;
  private final String name;

  ScoreTypeEnum(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}
