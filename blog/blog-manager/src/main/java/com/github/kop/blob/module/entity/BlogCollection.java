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
 * 博客的收藏
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog_collection")
public class BlogCollection implements Serializable {
    /**
     * 收藏主键
     */
    @TableId(value = "collection_id", type = IdType.AUTO)
    private Long collectionId;

    /**
     * 文章的主键
     */
    @TableField(value = "article_id")
    private Long articleId;

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