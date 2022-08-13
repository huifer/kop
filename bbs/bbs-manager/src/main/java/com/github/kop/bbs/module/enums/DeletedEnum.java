package com.github.kop.bbs.module.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 14:59
 */
@Getter
@AllArgsConstructor
public enum DeletedEnum {

    TRUE(1,"删除"),
    FALSE(0,"未删除"),
    ;

    private final Integer code;

    private final String desc;

}
