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

/** 话题评论数量记录表 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_topic_comment_count")
public class TopicCommentCount {
  /** 主键 */
  @TableId(value = "topic_comment_count_id", type = IdType.INPUT)
  private Long topicCommentCountId;

  /** 申请表主键 */
  @TableField(value = "topic_id")
  private Long topicId;

  /** 投票票数 */
  @TableField(value = "comment_count")
  private Long commentCount;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 更新时间 */
  @TableField(value = "update_time")
  private LocalDateTime updateTime;

  /** 是否删除 0 为未删除、1 为已删除 */
  @TableField(value = "deleted")
  private Integer deleted;
}
