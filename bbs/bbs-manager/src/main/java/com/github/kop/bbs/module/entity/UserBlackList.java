package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 用户黑名单 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_user_black_list")
public class UserBlackList implements Serializable {
  /** 黑名单主键 */
  @TableId(value = "black_list_id", type = IdType.AUTO)
  private Long blackListId;

  /** 被拉黑的人 */
  @TableField(value = "black_user_id")
  private Long blackUserId;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 创建用户 */
  @TableField(value = "create_user_id")
  private Long createUserId;

  private static final long serialVersionUID = 1L;
}
