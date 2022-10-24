package com.github.kop.blob.module.res.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auth ahxiaoqi
 * @desc 标签返回值
 * @time 2022/7/31 16:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("标签列表返回对象")
public class TagListRes {

  /** 标签id */
  @ApiModelProperty(value = "标签id")
  private Long tagId;

  /** 标签名称 */
  @ApiModelProperty(value = "标签名称")
  private String tagName;
}
