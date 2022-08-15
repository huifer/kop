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

/** 用户反馈 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_feedback_record")
public class FeedbackRecord implements Serializable {
  /** 用户反馈主键 */
  @TableId(value = "feedback_record_id", type = IdType.AUTO)
  private Long feedbackRecordId;

  /** 反馈内容 */
  @TableField(value = "feedback_text")
  private String feedbackText;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 创建用户 */
  @TableField(value = "create_user_id")
  private Long createUserId;

  private static final long serialVersionUID = 1L;
}
