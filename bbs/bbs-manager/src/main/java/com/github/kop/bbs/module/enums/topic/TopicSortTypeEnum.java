package com.github.kop.bbs.module.enums.topic;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/1 22:04
 */
@Getter
@AllArgsConstructor
public enum TopicSortTypeEnum {
  CREATE_TIME(1, "创建时间"),

  HOT(2, "热度");

  private final Integer code;

  private final String desc;
}
