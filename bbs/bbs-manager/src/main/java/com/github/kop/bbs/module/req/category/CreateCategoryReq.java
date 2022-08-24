package com.github.kop.bbs.module.req.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/11 21:40
 */
@Data
@ApiModel("版块的添加")
public class CreateCategoryReq {

  /** 分类名称 */
  @ApiModelProperty(value = "板块名称")
  private String categoryName;

  /** 分类图标 */
  @ApiModelProperty(value = "板块图标")
  private String categoryIcon;

  /** 上级id */
  @ApiModelProperty(value = "上级id")
  private Long parentId;

  /** 分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员 */
  @ApiModelProperty(value = "分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员")
  private Integer viewPermissions;
}
