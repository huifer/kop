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

/** 评论的点赞日志 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_comment_thumbs_log")
public class CommentThumbsLog implements Serializable {
  /** 点赞日志主键 */
  @TableId(value = "thumbs_log_id", type = IdType.AUTO)
  private Long thumbsLogId;

  /** 帖子评论主键 */
  @TableField(value = "comment_id")
  private Long commentId;

  /** 创建时间 */
  @TableField(value = "create_time")
  private LocalDateTime createTime;

  /** 创建用户 */
  @TableField(value = "create_user_id")
  private Long createUserId;

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
