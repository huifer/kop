package com.github.kop.rbac.module.res.user;

import lombok.Data;

@Data
public class UserLoginRes {
    private String phone;

    private String name;

    private Integer grade;

    private Long companyId;

    private String token;

    private String deptName;
    private String mainPostName;
}
