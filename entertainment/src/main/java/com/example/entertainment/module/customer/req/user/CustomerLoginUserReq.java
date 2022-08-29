package com.example.entertainment.module.customer.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户登陆")
@Data
public class CustomerLoginUserReq {

  @ApiModelProperty("手机号")
  private String phone;
  @ApiModelProperty("密码")
  private String password;
}
