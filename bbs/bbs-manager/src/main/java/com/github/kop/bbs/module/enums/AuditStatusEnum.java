package com.github.kop.bbs.module.enums;

import com.github.kop.bbs.module.ex.BizException;
import com.github.kop.bbs.module.ex.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 审核状态 0 待审核  1 审核通过 2 审核不通过
 */
@AllArgsConstructor
@Getter
public enum AuditStatusEnum {
  TO_AUDIT(0, "待审核"),
  PASS(1, "审核通过"),
  NO_PASS(2, "审核不通过"),
  ;
  private final Integer code;

  private final String desc;

  public static AuditStatusEnum conv(int code) {
    for (AuditStatusEnum value : values()) {
      if (value.code == code) {

        return value;
      }
    }
    throw new BizException(ExceptionEnums.CONV_ENUM_EXCEPTION);
  }


  public static AuditStatusEnum conv(boolean b) {
    if (b) {
      return PASS;
    } else {
      return NO_PASS;
    }
  }

}
