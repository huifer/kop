package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 论坛的话题评论
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_topic_comment")
public class TopicComment {
    /**
     * 话题评论主键
     */
    @TableId(value = "topic_comment_id", type = IdType.INPUT)
    private Long topicCommentId;

    /**
     * 评论类别 1 话题 2 话题评论
     */
    @TableField(value = "topic_comment_type")
    private Integer topicCommentType;

    /**
     * 上级id
     */
    @TableField(value = "pid")
    private Long pid;

    /**
     * 最上级id
     */
    @TableField(value = "top_id")
    private Long topId;

    /**
     * 层级路径
     */
    @TableField(value = "level_path")
    private Long levelPath;

    /**
     * 点赞数
     */
    @TableField(value = "thumbs_cont")
    private Long thumbsCont;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * IP城市地址
     */
    @TableField(value = "ip_loc")
    private String ipLoc;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user_id")
    private Long createUserId;

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

    /**
     * 主体id
     */
    @TableField(value = "ref_id")
    private Long refId;
}