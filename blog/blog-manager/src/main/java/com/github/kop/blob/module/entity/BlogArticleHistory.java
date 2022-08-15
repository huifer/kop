package com.github.kop.blob.module.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客文章修改历史
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog_article_history")
public class BlogArticleHistory implements Serializable {
    /**
     * 文章主键
     */
    @TableId(value = "history_id", type = IdType.AUTO)
    private Long historyId;

    /**
     * 文章主键
     */
    @TableField(value = "article_id")
    private Long articleId;

    /**
     * 文章标题
     */
    @TableField(value = "article_title")
    private String articleTitle;

    /**
     * 文章内容
     */
    @TableField(value = "article_content")
    private String articleContent;

    /**
     * 评论开关
     */
    @TableField(value = "comments_status")
    private Integer commentsStatus;

    /**
     * 文章可见类型 0 全部可见 1 仅我可见 2 粉丝可见
     */
    @TableField(value = "visible_status")
    private Integer visibleStatus;

    /**
     * 历史版本创建时间
     */
    @TableField(value = "history_create_time")
    private Date historyCreateTime;

    /**
     * 历史版本创建用户
     */
    @TableField(value = "history_create_user_id")
    private Long historyCreateUserId;

    /**
     * 历史版本更新时间
     */
    @TableField(value = "history_update_time")
    private Date historyUpdateTime;

    /**
     * 历史版本更新用户
     */
    @TableField(value = "history_update_user_id")
    private Long historyUpdateUserId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 更新用户
     */
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private Long updateUserId;

    /**
     * 逻辑删除标记位
     */
    @TableField(value = "deleted")@TableLogic
    private Integer deleted;

    /**
     * 乐观锁
     */
    @TableField(value = "version")@Version
    private Long version;

    private static final long serialVersionUID = 1L;
}