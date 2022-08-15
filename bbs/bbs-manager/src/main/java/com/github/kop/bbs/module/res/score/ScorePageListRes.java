package com.github.kop.bbs.module.res.score;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/14 15:00
 */
@ApiModel("积分分页返回的结果")
@Data
public class ScorePageListRes {

  /** 积分规则主键 */
  @ApiModelProperty(value = "积分规则主键")
  private Long roleId;

  /** 积分类型 1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分 */
  @ApiModelProperty(value = "积分类型")
  private String roleType;

  /** 增减类型 0 减少 1 增加 */
  @ApiModelProperty(value = "增减类型")
  private String addType;

  /** 周期内积分数量 0 不限 */
  @ApiModelProperty(value = "积分数量 0 自定义 ")
  private String score;

  /** 积分周期(周期内只能得一次分) 0 没有周期(即不限制得分) 1 天 2 周 3 月 4 年 */
  @ApiModelProperty(value = "积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ")
  private String scoreCycle;
}
