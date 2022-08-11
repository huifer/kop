package com.github.kop.bbs.module.req.category;

import com.github.kop.bbs.module.ex.NoceException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/11 22:44
 */
@Getter
@AllArgsConstructor
public enum ViewPermissionsEnum {

    //分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员

    ALL(0,"全部"),

    LOGIN(1,"登录用户"),

    PAY_SCORE(2,"支付积分"),

    VIP(4,"会员"),
;

    private final Integer code;

    private final String desc;


    public static ViewPermissionsEnum getEnumByCode(Integer code){
        ViewPermissionsEnum[] values = values();
        for (ViewPermissionsEnum value : values) {
            if(value.code.equals(code)){
                return value;
            }
        }
        throw new NoceException("没有对应的枚举");
    }
}
