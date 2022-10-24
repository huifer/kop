package com.github.kop.bbs.module.enums.message;

import com.github.kop.bbs.module.ex.BizException;
import com.github.kop.bbs.module.ex.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;

/** 1动态，2评论，3帖子回复通知，4评论回复通知 5私信，99系统通知 */
@AllArgsConstructor
@Getter
public enum MessageTypeEnum {
  DYNAMIC(1, "动态"),
  COMMENT(2, "评论"),
  POST_REPLY(3, "帖子回复通知"),
  COMMENT_reply(4, "评论回复通知"),
  PRIVATE_MESSAGE(5, "私信"),
  SYS_MESSAGE(99, "系统通知"),
  ;
  private final int code;
  private final String name;

  public static MessageTypeEnum conv(int code) {
    for (MessageTypeEnum value : values()) {
      if (value.code == code) {
        return value;
      }
    }
    throw new BizException(ExceptionEnums.CONV_ENUM_EXCEPTION);
  }
}
