package com.github.kop.bbs.module.enums.score;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc 积分类型枚举
 * @time 2022/8/14 17:06
 */
@Getter
@AllArgsConstructor
public enum ScoreRoleEnum {

    SIGN(1,"签到积分"),

    INVITATION(2,"发帖积分"),

    COMMENT(3,"评论积分"),

    PUNISH(4,"惩罚积分")
    ;
    private final Integer code;

    private final String desc;


    public static String getDescByCode(Integer code){
        ScoreRoleEnum[] values = values();
        for (ScoreRoleEnum value : values) {
            if(value.code.equals(code)){
                return value.desc;
            }
        }
        return "";
    }
}
