package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 论坛的帖子评论
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_invitation_comment")
public class InvitationComment {
    /**
     * 帖子评论主键
     */
    @TableId(value = "invitation_comment_id", type = IdType.INPUT)
    private Long invitationCommentId;

    /**
     * 评论类别 1 帖子 2 帖子评论
     */
    @TableField(value = "invitation_comment_type")
    private Integer invitationCommentType;

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
     * 评论内容
     */
    @TableField(value = "comment_content")
    private Long commentContent;

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
    @TableField(value = "create_time",fill = FieldFill.INSERT)
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