package com.github.kop.bbs.module.enums.userCategoryApply;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/17 22:47
 */
@Getter
@AllArgsConstructor
public enum UserCategoryApplyStatus {

    /**
     * 状态 0 待审核 1 审核通过 2 审核不通过
     */
    PENDING_REVIEW(0,"待审核"),

    PASS(1,"审核通过"),

    NOT_PASS(2,"审核不通过")

    ;
    private final Integer code;

    private final String desc;


    public static String getDescByCode(Integer code){
        UserCategoryApplyStatus[] values = values();
        for (UserCategoryApplyStatus value : values) {
            if(value.code.equals(code)){
                return value.desc;
            }
        }
        return "";
    }

}