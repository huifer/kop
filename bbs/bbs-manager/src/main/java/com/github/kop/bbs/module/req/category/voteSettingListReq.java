package com.github.kop.bbs.module.req.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 09:44
 */
@Data
public class voteSettingListReq {

  /** 版块id */
  @ApiModelProperty(value = "版块id")
  private Long categoryId;

  @ApiModelProperty(value = "排序类型 0 申请开始时间 1 投票开始时间")
  private Integer orderType;

  @AllArgsConstructor
  @Getter
  public enum voteSettingListOrderType {
    APPLY_TIME(0, "申请开始时间"),
    VOTE_TIME(1, "投票开始时间");

    private final Integer code;

    private final String desc;
  }
}
