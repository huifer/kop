package com.github.kop.bbs.module.enums.invitation;

import com.github.kop.bbs.module.ex.BizException;
import com.github.kop.bbs.module.ex.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 帖子正文类型 1 富文本 2 md
 */
@Getter
@AllArgsConstructor
public enum InvitationTextTypeEnum {
  RICH_TEXT(1, "富文本"),
  MARKDOWN(2, "markdown"),
  ;
  private final int code;
  private final String name;


  public static InvitationTextTypeEnum conv(int code) {
    for (InvitationTextTypeEnum value : values()) {
      if (value.code == code) {
        return value;
      }
    }
    throw new BizException(ExceptionEnums.CONV_ENUM_EXCEPTION);

  }
}
