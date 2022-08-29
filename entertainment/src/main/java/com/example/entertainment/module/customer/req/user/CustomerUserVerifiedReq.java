package com.example.entertainment.module.customer.req.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("实名认证参数")
@Data
public class CustomerUserVerifiedReq {

  @ApiModelProperty("用户id")
  private Integer userId;
  @ApiModelProperty("身份证正面照片")
  private String cardFrontImage;

  @ApiModelProperty("身份证反面照片")
  private String cardBackImage;

  @ApiModelProperty("真实姓名")
  private String name;

  @ApiModelProperty("身份证号")
  private String card;


}
