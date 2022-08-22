package com.github.kop.bbs.module.req.message;

import com.github.kop.bbs.module.enums.TipsTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("消息查询参数")
public class MessageQueryReq {

  @ApiModelProperty("通知类型")
  private Integer tipsType;


  @ApiModelProperty("通知类型枚举")
  private TipsTypeEnum tipsTypeEnum;


  public void setTipsType(Integer tipsType) {
    this.tipsType = tipsType;
    this.tipsTypeEnum = TipsTypeEnum.conv(tipsType);
  }


}
