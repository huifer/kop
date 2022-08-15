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

/** 论坛的帖子 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_invitation")
public class Invitation implements Serializable {
  /** 帖子主键 */
  @TableId(value = "invitation_id", type = IdType.AUTO)
  private Long invitationId;

  /** 帖子正文类型 1 富文本 2 md */
  @TableField(value = "text_type")
  private Integer textType;

  /** 论坛类别 */
  @TableField(value = "category_id")
  private Long categoryId;

  /** 帖子类型：0动态、1板块内容 */
  @TableField(value = "`type`")
  private Integer type;

  /** 话题主键 动态可以选择加话题 */
  @TableField(value = "`topic_id`")
  private Integer topicId;

  /** 帖子正文 */
  @TableField(value = "`text`")
  private String text;

  /** 文章状态 0 待审核 1 审核通过 */
  @TableField(value = "article_status")
  private Integer articleStatus;

  /** 是否置顶 */
  @TableField(value = "is_top")
  private Integer isTop;

  /** 是否精华 */
  @TableField(value = "is_essence")
  private Integer isEssence;

  /** 是否锁定 */
  @TableField(value = "is_lock")
  private Integer isLock;

  /** 最新回复时间 */
  @TableField(value = "latest_replied_on")
  private Long latestRepliedOn;

  /** tag字符串,逗号隔开 */
  @TableField(value = "tag_str")
  private String tagStr;

  /** IP地址 */
  @TableField(value = "ip")
  private String ip;

  /** IP城市地址 */
  @TableField(value = "ip_loc")
  private String ipLoc;

  /** 浏览数 */
  @TableField(value = "views_count")
  private Long viewsCount;

  /** 评论数 */
  @TableField(value = "comments_count")
  private Long commentsCount;

  /** 评论开关 */
  @TableField(value = "comments_status")
  private Integer commentsStatus;

  /** 文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见 */
  @TableField(value = "visible_status")
  private Integer visibleStatus;

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
