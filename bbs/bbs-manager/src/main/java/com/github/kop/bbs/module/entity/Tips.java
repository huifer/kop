package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 论坛的站内信
 */
@ApiModel(value = "论坛的站内信")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_tips")
public class Tips implements Serializable {
    /**
     * 站内信主键
     */
    @TableId(value = "tips_id", type = IdType.AUTO)
    @ApiModelProperty(value = "站内信主键")
    private Long tipsId;

    /**
     * 提示类型 1 帖子回复通知 2 评论回复通知
     */
    @TableField(value = "tpis_type")
    @ApiModelProperty(value = "提示类型 1 帖子回复通知 2 评论回复通知")
    private Integer tpisType;

    /**
     * 回复的帖子或者评论的id
     */
    @TableField(value = "from_id")
    @ApiModelProperty(value = "回复的帖子或者评论的id")
    private Long fromId;

    /**
     * 回复的内容的id
     */
    @TableField(value = "reply_id")
    @ApiModelProperty(value = "回复的内容的id")
    private Long replyId;

    /**
     * 站内信状态 0 未读 1 已读
     */
    @TableField(value = "tips_status")
    @ApiModelProperty(value = "站内信状态 0 未读 1 已读")
    private Integer tipsStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 逻辑删除标记位
     */
    @TableField(value = "deleted")
    @ApiModelProperty(value = "逻辑删除标记位")
    private Integer deleted;

    private static final long serialVersionUID = 1L;
}