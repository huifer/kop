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
 * 博客的专栏
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog_special_column")
public class BlogSpecialColumn implements Serializable {
    /**
     * 专栏主键
     */
    @TableId(value = "special_column_id", type = IdType.AUTO)
    private Long specialColumnId;

    /**
     * 专栏标题
     */
    @TableField(value = "special_column_title")
    private String specialColumnTitle;

    /**
     * 专栏简介
     */
    @TableField(value = "special_column_desc")
    private String specialColumnDesc;

    /**
     * 父级id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 层级路径
     */
    @TableField(value = "level_path")
    private String levelPath;

    /**
     * 专栏图片
     */
    @TableField(value = "img")
    private String img;

    /**
     * 订阅数量
     */
    @TableField(value = "comments_count")
    private Long commentsCount;

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