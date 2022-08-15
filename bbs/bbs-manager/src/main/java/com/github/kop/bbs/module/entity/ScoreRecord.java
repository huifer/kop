package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 论坛的积分记录 */
@ApiModel(value = "论坛的积分记录")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_score_record")
public class ScoreRecord implements Serializable {
  /** 积分日志主键 */
  @TableId(value = "score_record_id", type = IdType.AUTO)
  @ApiModelProperty(value = "积分日志主键")
  private Long scoreRecordId;

  /** 积分规则 */
  @TableField(value = "role_id")
  @ApiModelProperty(value = "积分规则")
  private Long roleId;

  /** 具体加的分数 */
  @TableField(value = "score_count")
  @ApiModelProperty(value = "具体加的分数 ")
  private Long scoreCount;

  /** 积分所有人 */
  @TableField(value = "user_id")
  private Long userId;

  /** 创建时间 */
  @TableField(value = "create_time")
  @ApiModelProperty(value = "创建时间")
  private LocalDateTime createTime;

  /** 创建用户 */
  @TableField(value = "create_user_id")
  @ApiModelProperty(value = "创建用户")
  private Long createUserId;

  private static final long serialVersionUID = 1L;
}
