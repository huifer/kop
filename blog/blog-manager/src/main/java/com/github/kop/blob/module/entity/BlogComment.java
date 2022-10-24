package com.github.kop.blob.module.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 博客的评论 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog_comment")
public class BlogComment implements Serializable {
  /** 评论主键 */
  @TableId(value = "comment_id", type = IdType.AUTO)
  private Long commentId;

  /** 文章id */
  @TableField(value = "article_id")
  private Long articleId;

  /** 评论内容 */
  @TableField(value = "comment_content")
  private String commentContent;

  /** ip归属 */
  @TableField(value = "ip_belonging")
  private String ipBelonging;

  /** 点赞数 */
  @TableField(value = "thumbs_cont")
  private Long thumbsCont;

  /** 是否置顶 0 否 1 是 */
  @TableField(value = "placed_top_status")
  private Integer placedTopStatus;

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
