package com.github.kop.bbs.module.enums;

import com.github.kop.bbs.module.ex.BizException;
import com.github.kop.bbs.module.ex.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;

/** 申诉类别 1 账号申诉 2 帖子申诉 */
@AllArgsConstructor
@Getter
public enum AppealTypeEnum {
  ACCOUNT(1, "账号申诉"),
  INVITATION(2, "帖子申诉");
  private final Integer code;

  private final String desc;

  public static AppealTypeEnum conv(int appealType) {
    for (AppealTypeEnum value : values()) {
      if (value.code == appealType) {
        return value;
      }
    }
    throw new BizException(ExceptionEnums.CONV_ENUM_EXCEPTION);
  }
}
