package com.github.kop.bbs.module.enums.appeal;

import com.github.kop.bbs.module.ex.BizException;
import com.github.kop.bbs.module.ex.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:40
 */
@AllArgsConstructor
@Getter
public enum AppealStatusEnum {
  PENDING(1, "处理中"),
  FINISH(2, "处理完成"),
  ;
  private final Integer code;

  private final String desc;

  public static AppealStatusEnum conv(Integer appealStatus) {
    for (AppealStatusEnum value : values()) {
      if (value.code.equals(appealStatus)) {
        return value;
      }
    }
    throw new BizException(ExceptionEnums.CONV_ENUM_EXCEPTION);
  }
}
