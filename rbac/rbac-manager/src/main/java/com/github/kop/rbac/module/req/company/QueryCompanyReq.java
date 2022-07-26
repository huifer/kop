package com.github.kop.rbac.module.req.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "企业查询请求参数")
public class QueryCompanyReq {
  @ApiModelProperty(value = "企业名称")
  private String name;

  @ApiModelProperty(value = "企业地址")
  private String address;

  @ApiModelProperty(value = "社会信用编码")
  private String socialCreditCode;
}
