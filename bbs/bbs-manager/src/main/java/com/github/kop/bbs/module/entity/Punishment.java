package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 论坛的惩罚 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_punishment")
public class Punishment implements Serializable {
  /** 积分惩罚主键 */
  @TableId(value = "punishment_id", type = IdType.AUTO)
  private Long punishmentId;

  /** 惩罚用户id */
  @TableField(value = "user_id")
  private Long userId;

  /** 惩罚依据 */
  @TableField(value = "punishment_basis")
  private String punishmentBasis;

  /** 惩罚分数 */
  @TableField(value = "score_count")
  private Integer scoreCount;

  /** 惩罚状态 0 未惩罚 1 已惩罚 3 已撤销 */
  @TableField(value = "punishment_status")
  private Integer punishmentStatus;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 创建用户 */
  @TableField(value = "create_user_id")
  private Long createUserId;

  /** 更新时间 */
  @TableField(value = "update_time")
  private LocalDateTime updateTime;

  /** 更新用户 */
  @TableField(value = "update_user_id")
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
