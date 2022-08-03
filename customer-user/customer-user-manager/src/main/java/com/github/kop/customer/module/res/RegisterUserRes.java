package com.github.kop.customer.module.res;

import lombok.Data;

@Data
public class RegisterUserRes {


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


}
