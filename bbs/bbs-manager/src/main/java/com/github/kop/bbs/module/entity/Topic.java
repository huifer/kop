package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 话题 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_topic")
public class Topic implements Serializable {
  /** 话题主键 */
  @TableId(value = "topic_id", type = IdType.AUTO)
  private Long topicId;

  /** 话题标题 */
  @TableField(value = "topic_title")
  private String topicTitle;

  /** 话题内容 */
  @TableField(value = "topic_content")
  private String topicContent;

  /** 话题状态 0 待审核 1 审核通过 2 审核不通过 */
  @TableField(value = "topic_status")
  private Integer topicStatus;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 创建用户 */
  @TableField(value = "create_user_id")
  private Long createUserId;

  private static final long serialVersionUID = 1L;
}
