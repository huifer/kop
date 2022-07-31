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
 * 博客的关注
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "blog_focus")
public class BlogFocus implements Serializable {
    /**
     * 关注主键
     */
    @TableId(value = "focus_id", type = IdType.AUTO)
    private Long focusId;

    /**
     * 关注的对应类型的主键
     */
    @TableField(value = "id_to_type")
    private Long idToType;

    /**
     * 关注的类型 1 人 2 文章 3 专栏
     */
    @TableField(value = "focus_type")
    private Integer focusType;

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