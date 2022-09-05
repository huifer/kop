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
 * 论坛的申诉
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_appeal")
public class Appeal {
    private static final long serialVersionUID = 1L;
    /**
     * 申诉主键
     */
    @TableId(value = "appeal_id", type = IdType.INPUT)
    private Long appealId;

    /**
     * 申诉类别 1 账号申诉 2 帖子申诉
     */
    @TableField(value = "appeal_type")
    private Integer appealType;

    /**
     * 申诉状态 1 处理中 2 处理完成
     */
    @TableField(value = "appeal_status")
    private Integer appealStatus;

    /**
     * 申诉标题
     */
    @TableField(value = "appeal_title")
    private String appealTitle;

    /**
     * 申诉描述
     */
    @TableField(value = "appeal_text")
    private String appealText;

    /**
     * 申诉附件
     */
    @TableField(value = "appeal_file")
    private String appealFile;

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
     * 申诉人
     */
    @TableField(value = "appeal_user_id")
    private Long appealUserId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;
}