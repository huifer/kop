package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 版主投票表 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_user_category_vote_setting")
public class UserCategoryVoteSetting {
  /** 主键 */
  @TableId(value = "vote_setting_id", type = IdType.INPUT)
  private Long voteSettingId;

  /** 版块id */
  @TableField(value = "category_id")
  private Long categoryId;

  /** 申请人数限制 0 不限制 */
  @TableField(value = "application_count")
  private Long applicationCount;

  /** 已经申请的人 */
  @TableField(value = "already_count")
  private Long alreadyCount;

  /** 申请开始时间(时间范围内允许申请) */
  @TableField(value = "apply_start_time")
  private LocalDateTime applyStartTime;

  /** 申请结束时间 */
  @TableField(value = "apply_end_time")
  private LocalDateTime applyEndTime;

  /** 投票开始时间(时间范围内允许投票) */
  @TableField(value = "vote_start_time")
  private LocalDateTime voteStartTime;

  /** 投票结束时间 */
  @TableField(value = "vote_end_time")
  private LocalDateTime voteEndTime;

  /** 是否删除 0 为未删除、1 为已删除 */
  @TableField(value = "deleted")
  private Integer deleted;
}
