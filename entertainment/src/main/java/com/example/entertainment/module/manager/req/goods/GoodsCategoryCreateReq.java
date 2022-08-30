package com.example.entertainment.module.manager.req.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("商品系列创建参数")
@Data
public class GoodsCategoryCreateReq {

  @ApiModelProperty("系列名称")
  private String name;

  @ApiModelProperty("系列图片")
  private String image;

  @ApiModelProperty("排序值")
  private Integer order;
  @ApiModelProperty("是否展示")
  private Boolean isShow;

}
