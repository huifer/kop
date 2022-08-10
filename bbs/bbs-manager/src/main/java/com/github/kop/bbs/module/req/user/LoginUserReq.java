package com.github.kop.bbs.module.req.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc 登录
 * @time 2022/8/10 23:02
 */
@Data
public class LoginUserReq {


    /** 用户名 */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

}
