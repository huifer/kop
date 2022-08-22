package com.github.kop.bbs.module.enums;

// 1 天 2 周 3 月 4 年
public enum ScoreCycleEnum {
  DAY(1, "天"),
  WEEK(1, "周"),
  MONTH(1, "月"),
  YEAR(1, "年"),
  ;
  private final int code;
  private final String name;

  ScoreCycleEnum(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public static ScoreCycleEnum conv(Integer scoreCycle) {
    for (ScoreCycleEnum value : values()) {
      if (value.code == scoreCycle) {
        return value;
      }
    }
    throw new RuntimeException("周期编号无法转换为具体周期类型");
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }
}
