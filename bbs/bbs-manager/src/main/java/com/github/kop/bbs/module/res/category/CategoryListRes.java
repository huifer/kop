package com.github.kop.bbs.module.res.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/11 22:32
 */
@ApiModel("分类列表返回结果")
@Data
public class CategoryListRes {

  /** 分类名称 */
  @ApiModelProperty(value = "分类名称")
  private String categoryName;
  /** 父板块 */
  @ApiModelProperty(value = "父板块名称")
  private String parentName;

  /** 分类图标 */
  @ApiModelProperty(value = "分类图标")
  private String categoryIcon;

  @ApiModelProperty(value = "帖子数量")
  private Long invitationCount;

  /** 分类查看权限 0 全部 1 登录用户 2 支付积分(会员免费积分查看可以视为直接支付过积分) 4 会员 */
  @ApiModelProperty(value = "分类查看权限")
  private String viewPermissions;
}
