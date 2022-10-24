package com.github.kop.bbs.module.req.invitation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("帖子审核参数")
@Data
public class InvitationAuditReq {

  @ApiModelProperty("帖子id")
  private Long invitationId;

  @ApiModelProperty("审核意见")
  private boolean pass;

  @ApiModelProperty("审核意见文本")
  private String context;
}
