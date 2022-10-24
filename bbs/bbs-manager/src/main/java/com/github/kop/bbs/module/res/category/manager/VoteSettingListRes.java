package com.github.kop.bbs.module.res.category.manager;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 09:46
 */
@ApiModel("版主投票设置列表")
@Data
public class VoteSettingListRes {

  /** 版块id */
  @ApiModelProperty(value = "版块id")
  private Long categoryId;

  /** 申请人数限制 0 不限制 */
  @ApiModelProperty(value = "申请人数限制 0 不限制")
  private String applicationCount;

  /** 已经申请的人 */
  @ApiModelProperty(value = "已经申请的人数量")
  private Long alreadyCount;

  /** 申请开始时间(时间范围内允许申请) */
  @ApiModelProperty(value = "申请开始时间")
  private LocalDateTime applyStartTime;

  /** 申请结束时间 */
  @ApiModelProperty(value = "申请结束时间")
  private LocalDateTime applyEndTime;

  /** 投票开始时间(时间范围内允许投票) */
  @ApiModelProperty(value = "投票开始时间")
  private LocalDateTime voteStartTime;

  /** 投票结束时间 */
  @ApiModelProperty(value = "投票结束时间")
  private LocalDateTime voteEndTime;
}
