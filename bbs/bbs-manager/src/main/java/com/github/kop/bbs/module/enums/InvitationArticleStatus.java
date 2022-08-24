package com.github.kop.bbs.module.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ** 帖子状态 0 待审核 1 审核通过
 */
@AllArgsConstructor
@Getter
public enum InvitationArticleStatus {
  PENDING_REVIEW(0, "待审核"),
  PASS(1, "审核通过"),
  ;
  private final int code;
  private final String name;
}
