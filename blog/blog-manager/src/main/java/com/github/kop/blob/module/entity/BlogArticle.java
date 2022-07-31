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
 * 博客的文章
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog_article")
public class BlogArticle implements Serializable {
    /**
     * 文章主键
     */
    @TableId(value = "article_id", type = IdType.AUTO)
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
     * 文章状态 0 待审核 1 审核通过
     */
    @TableField(value = "article_status")
    private Integer articleStatus;

    /**
     * 点赞数
     */
    @TableField(value = "thumbs_cont")
    private Long thumbsCont;

    /**
     * 浏览数
     */
    @TableField(value = "views_count")
    private Long viewsCount;

    /**
     * 评论数
     */
    @TableField(value = "comments_count")
    private Long commentsCount;

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
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    private Long version;

    private static final long serialVersionUID = 1L;
}