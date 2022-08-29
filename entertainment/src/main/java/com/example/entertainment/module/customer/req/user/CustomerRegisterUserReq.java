package com.example.entertainment.module.customer.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户注册参数")
@Data
public class CustomerRegisterUserReq {

  @ApiModelProperty("手机号")
  private String phone;
  @ApiModelProperty("密码")
  private String password;
  @ApiModelProperty("邀请码")
  private String uuid;
}
