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
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_score_record")
public class ScoreRecord implements Serializable {
  /** 积分日志主键 */
  @TableId(value = "score_record_id", type = IdType.AUTO)
  private Long scoreRecordId;

  /** 积分规则 */
  @TableField(value = "score_rule_id")
  private Long scoreRuleId;

  /** 具体加的分数 */
  @TableField(value = "score_count")
  private Long scoreCount;

  /** 积分所有人 */
  @TableField(value = "user_id")
  private Long userId;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 积分类型 */
  @TableField(value = "score_type")
  private Integer scoreType;

  /** 创建用户 */
  @TableField(value = "create_user_id")
  private Long createUserId;

  /** 周期类型  积分周期类型(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 */
  @TableField(value = "score_cycle")
  private Integer scoreCycle;

  /** 周期数 */
  @TableField(value = "cycle_count")
  private Integer cycleCount;

  private static final long serialVersionUID = 1L;
}
