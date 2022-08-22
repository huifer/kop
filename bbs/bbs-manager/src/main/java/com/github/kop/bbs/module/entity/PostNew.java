package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 论坛的动态
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_post_new")
public class PostNew {
    /**
     * 动态主键
     */
    @TableId(value = "post_new_id", type = IdType.INPUT)
    private Long postNewId;

    /**
     * 话题主键 动态可以选择加话题
     */
    @TableField(value = "topic_id")
    private Long topicId;

    /**
     * 详细内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 逻辑删除标记位
     */
    @TableField(value = "deleted")
    private Integer deleted;
}