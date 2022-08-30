package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 版主票数记录表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_vote_ticket_log")
public class VoteTicketLog {
    /**
     * 主键
     */
    @TableId(value = "ticket_count_log_id", type = IdType.INPUT)
    private Long ticketCountLogId;

    /**
     * 申请表主键
     */
    @TableField(value = "apply_id")
    private Long applyId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 是否删除 0 为未删除、1 为已删除
     */
    @TableField(value = "deleted")
    private Integer deleted;
}