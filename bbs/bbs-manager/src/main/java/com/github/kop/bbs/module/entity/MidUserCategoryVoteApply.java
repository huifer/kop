package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 版主投票申请表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_mid_user_category_vote_apply")
public class MidUserCategoryVoteApply {
    /**
     * 主键
     */
    @TableId(value = "apply_id", type = IdType.INPUT)
    private Long applyId;

    /**
     * 版主投票表主键
     */
    @TableField(value = "vote_setting_id")
    private Long voteSettingId;

    /**
     * 版块id
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 投票票数
     */
    @TableField(value = "ticket_count")
    private Long ticketCount;

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