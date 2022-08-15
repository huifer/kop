package com.github.kop.bbs.module.enums.score;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc 增减类型枚举
 * @time 2022/8/14 17:06
 */
@Getter
@AllArgsConstructor
public enum ScoreAddTypeEnum {
  REDUCE(0, "减少"),
  ADD(1, "增加"),
  ;
  private final Integer code;

  private final String desc;

  public static String getDescByCode(Integer code) {
    ScoreAddTypeEnum[] values = values();
    for (ScoreAddTypeEnum value : values) {
      if (value.code.equals(code)) {
        return value.desc;
      }
    }
    return "";
  }
}
