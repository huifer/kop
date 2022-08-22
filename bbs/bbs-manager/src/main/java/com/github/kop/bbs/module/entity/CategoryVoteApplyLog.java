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
    * 版主投票记录表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_category_vote_apply_log")
public class CategoryVoteApplyLog {
    /**
     * 版主投票记录主键
     */
    @TableId(value = "vote_apply_log_id", type = IdType.INPUT)
    private Long voteApplyLogId;

    /**
     * 版主投票申请表主键
     */
    @TableField(value = "apply_id")
    private Long applyId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user_id")
    private Long createUserId;
}