package com.github.kop.bbs.module.enums.score;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/14 17:08
 */
@Getter
@AllArgsConstructor
public enum ScoreCycleEnum {
    // 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年

    NONE(0,"没有周期"),
    DAY(1,"天"),
    WEEK(2,"周"),
    MONTH(3,"月"),
    YEAR(4,"年")

    ;
    private final Integer code;

    private final String desc;


    public static String getDescByCode(Integer code){
        ScoreCycleEnum[] values = values();
        for (ScoreCycleEnum value : values) {
            if(value.code.equals(code)){
                return value.desc;
            }
        }
        return "";
    }
}
