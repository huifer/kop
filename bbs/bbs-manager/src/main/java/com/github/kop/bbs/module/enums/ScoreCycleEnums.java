package com.github.kop.bbs.module.enums;

// 1 天 2 周 3 月 4 年
public enum ScoreCycleEnums {
  DAY(1, "天"),
  WEEK(1, "周"),
  MONTH(1, "月"),
  YEAR(1, "年"),
  ;
  private final int code;
  private final String name;

  ScoreCycleEnums(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public static ScoreCycleEnums conv(Integer scoreCycle) {
    for (ScoreCycleEnums value : values()) {
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
