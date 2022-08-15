package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 标签 */
@ApiModel(value = "标签")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_tag")
public class Tag implements Serializable {
  /** 标签ID */
  @TableId(value = "id", type = IdType.AUTO)
  @ApiModelProperty(value = "标签ID")
  private Long id;

  /** 创建者ID */
  @TableField(value = "user_id")
  @ApiModelProperty(value = "创建者ID")
  private Long userId;

  /** 标签名 */
  @TableField(value = "tag")
  @ApiModelProperty(value = "标签名")
  private String tag;

  /** 引用数 */
  @TableField(value = "quote_num")
  @ApiModelProperty(value = "引用数")
  private Long quoteNum;

  /** 创建时间 */
  @TableField(value = "create_time")
  @ApiModelProperty(value = "创建时间")
  private Long createTime;

  /** 修改时间 */
  @TableField(value = "update_time")
  @ApiModelProperty(value = "修改时间")
  private Long updateTime;

  /** 删除时间 */
  @TableField(value = "deleted_time")
  @ApiModelProperty(value = "删除时间")
  private Long deletedTime;

  /** 是否删除 0 为未删除、1 为已删除 */
  @TableField(value = "deleted")
  @TableLogic
  @ApiModelProperty(value = "是否删除 0 为未删除、1 为已删除")
  private Integer deleted;

  private static final long serialVersionUID = 1L;
}
