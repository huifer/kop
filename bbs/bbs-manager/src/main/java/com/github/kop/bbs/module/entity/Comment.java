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

/** 论坛的帖子评论 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_comment")
public class Comment implements Serializable {
  /** 帖子评论主键 */
  @TableId(value = "comment_id", type = IdType.AUTO)
  private Long commentId;

  /** 评论类别 1 帖子 2 评论 3 话题 */
  @TableField(value = "comment_type")
  private Integer commentType;
  /** 主体id */
  @TableField(value = "ref_id")
  private Long refId;
  /** 最上级id */
  @TableField(value = "top_id")
  private Long topId;

  /** 父级id */
  @TableField(value = "pid")
  private Long pid;

  /** 回复帖子为空如果是回复评论,整个评论id的层级路径 */
  @TableField(value = "level_path ")
  private Long levelPath ;

  /** 点赞数 */
  @TableField(value = "thumbs_cont")
  private Long thumbsCont;

  /** IP地址 */
  @TableField(value = "ip")
  private String ip;

  /** IP城市地址 */
  @TableField(value = "ip_loc")
  private String ipLoc;

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
