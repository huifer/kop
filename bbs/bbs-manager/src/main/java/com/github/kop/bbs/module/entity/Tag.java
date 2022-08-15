package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 标签 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_tag")
public class Tag implements Serializable {
  /** 标签ID */
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /** 创建者ID */
  @TableField(value = "user_id")
  private Long userId;

  /** 标签名 */
  @TableField(value = "tag")
  private String tag;

  /** 引用数 */
  @TableField(value = "quote_num")
  private Long quoteNum;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 修改时间 */
  @TableField(value = "update_time")
  private LocalDateTime updateTime;

  /** 删除时间 */
  @TableField(value = "deleted_time")
  private LocalDateTime deletedTime;

  /** 是否删除 0 为未删除、1 为已删除 */
  @TableField(value = "deleted")
  @TableLogic
  private Integer deleted;

  private static final long serialVersionUID = 1L;
}
