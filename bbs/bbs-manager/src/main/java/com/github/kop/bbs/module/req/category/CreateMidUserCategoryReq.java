package com.github.kop.bbs.module.req.category;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 15:53
 */
@ApiModel("添加版主的请求参数")
@Data
public class CreateMidUserCategoryReq {

  /** 用户id */
  @ApiModelProperty("用户id")
  private Long userId;

  /** 版块id */
  @ApiModelProperty("版块id")
  private Long categoryId;
}
