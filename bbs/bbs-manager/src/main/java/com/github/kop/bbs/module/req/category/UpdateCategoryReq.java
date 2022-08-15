package com.github.kop.bbs.module.req.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/11 21:40
 */
@ApiModel("更新版块的参数")
@Data
public class UpdateCategoryReq {

  @ApiModelProperty(value = "版块主键")
  private Long categoryId;

  /** 分类名称 */
  @ApiModelProperty(value = "分类名称")
  private String categoryName;

  /** 分类图标 */
  @ApiModelProperty(value = "分类图标")
  private String categoryIcon;

  /** 上级id */
  @ApiModelProperty(value = "上级id")
  private Long parentId;

  /** 分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员 */
  @ApiModelProperty(value = "分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员")
  private Integer viewPermissions;
}
