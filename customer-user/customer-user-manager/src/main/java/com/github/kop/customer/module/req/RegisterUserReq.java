package com.github.kop.customer.module.req;

import lombok.Data;

@Data
public class RegisterUserReq {


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
     * 密码
     */
    private String password;


}
