package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 申诉回执
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_appeal_receipt")
public class AppealReceipt {
    /**
     * 申诉回执主键
     */
    @TableId(value = "appeal_receipt_id", type = IdType.INPUT)
    private Long appealReceiptId;

    /**
     * 申诉主键
     */
    @TableField(value = "appeal_id")
    private Long appealId;

    /**
     * 申诉回执顺序
     */
    @TableField(value = "`order`")
    private Integer order;

    /**
     * 官方回复
     */
    @TableField(value = "appeal_official_reply")
    private String appealOfficialReply;

    /**
     * 用户回复
     */
    @TableField(value = "appeal_user_reply")
    private String appealUserReply;

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
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;
}