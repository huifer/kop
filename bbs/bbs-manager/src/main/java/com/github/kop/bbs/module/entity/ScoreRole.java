package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.kop.bbs.module.enums.score.ScoreTypeEnum;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 论坛的积分规则配置 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_score_role")
public class ScoreRole implements Serializable {
  /** 积分规则主键 */
  @TableId(value = "score_role_id", type = IdType.AUTO)
  private Long scoreRoleId;

  /**
   * 积分类型 2 发帖积分 3 评论积分 4 惩罚积分
   *
   * <p>{@link ScoreTypeEnum}
   */
  @TableField(value = "rule_type")
  private Integer ruleType;

  /** 增减类型 0 减少 1 增加 */
  @TableField(value = "add_type")
  private Integer addType;

  /** 获取的积分 */
  @TableField(value = "score")
  private Long score;
  /** 周期内最多获取的积分数量 */
  @TableField(value = "max_score")
  private Long maxScore;

  /** 积分周期(周期内只能得一次分) 0 没有周期(即不限制得分) 1 天 2 周 3 月 4 年 */
  @TableField(value = "score_cycle")
  private Integer scoreCycle;

  /** 周期具体数字 */
  @TableField(value = "cycle_num")
  private Integer cycleNum;

  /** 生效时间 */
  @TableField(value = "effect_time", fill = FieldFill.INSERT)
  private LocalDateTime effectTime;

  /** 创建时间 */
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;

  /** 创建用户 */
  @TableField(value = "create_user_id", fill = FieldFill.INSERT)
  private Long createUserId;

  /** 更新时间 */
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;

  /** 更新用户 */
  @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
  private Long updateUserId;

  /** 逻辑删除标记位 */
  @TableField(value = "deleted")
  @TableLogic
  private Integer deleted;

  /** 乐观锁 */
  @TableField(value = "version")
  @Version
  private Long version;

  private static final long serialVersionUID = 1L;
}
