package com.github.kop.bbs.module.res.invitation.customer;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("帖子查询对象")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvitationQueryResp {

  @ApiModelProperty("发帖人")
  private String createUserName;
  @ApiModelProperty("发帖人id")
  private Long createUserId;


  @ApiModelProperty("板块id")
  private Long categoryId;

  /** 帖子状态 0 待审核 1 审核通过 */
  @ApiModelProperty("帖子状态 0 待审核 1 审核通过")
  private Integer articleStatus;

  @ApiModelProperty("是否精华")
  private Integer isEssence;

  @ApiModelProperty("是否锁定")
  private Integer isLock;

  @ApiModelProperty("最新回复时间")
  private Long latestRepliedOn;
  @ApiModelProperty("tag")
  private List<String> tags;
  @ApiModelProperty("浏览数")
  private Long viewsCount;
  @ApiModelProperty("评论数")
  private Long commentsCount;


}
