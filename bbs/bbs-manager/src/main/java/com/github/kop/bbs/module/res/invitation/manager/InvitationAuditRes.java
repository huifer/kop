package com.github.kop.bbs.module.res.invitation.manager;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 21:24
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvitationAuditRes {

  /** 帖子主键 */
  @ApiModelProperty(value = "帖子id")
  private Long invitationId;

  @ApiModelProperty("发帖人")
  private String createUserName;

  @ApiModelProperty("发帖人id")
  private Long createUserId;

  /** 帖子状态 0 待审核 1 审核通过 */
  @ApiModelProperty("帖子状态 0 待审核 1 审核通过")
  private Integer articleStatus;

  @ApiModelProperty("板块id")
  private Long categoryId;

  @ApiModelProperty("板块id")
  private String categoryName;
}
