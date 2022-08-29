package com.example.entertainment.module.customer.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户更新参数")
@Data
public class CustomerUpdateUserReq {

  @ApiModelProperty("昵称")
  private String nickName;

  @ApiModelProperty("头像")
  private String headImage;

  @ApiModelProperty("登录密码")
  private String password;


}
