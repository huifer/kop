package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 论坛帖子审核记录表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_invitation_audit_log")
public class InvitationAuditLog {
    /**
     * 主键
     */
    @TableId(value = "invitation_audit_log_id", type = IdType.INPUT)
    private Long invitationAuditLogId;

    /**
     * 帖子主键
     */
    @TableField(value = "invitation_id")
    private Long invitationId;

    /**
     * 文章状态 0 待审核 1 审核通过
     */
    @TableField(value = "article_status")
    private Integer articleStatus;

    /**
     * 审核备注
     */
    @TableField(value = "audit_content")
    private String auditContent;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 是否删除 0 为未删除、1 为已删除
     */
    @TableField(value = "deleted")
    private Integer deleted;
}