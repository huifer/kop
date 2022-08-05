package com.github.kop.customer.module.res;

import lombok.Data;

@Data
public class UserInfoRes {
    private Long userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 性别
     */
    private Integer grade;

    /**
     * 是否关注
     */
    private boolean follow;
    /**
     * 是否拉黑
      */
    private boolean black;

}
