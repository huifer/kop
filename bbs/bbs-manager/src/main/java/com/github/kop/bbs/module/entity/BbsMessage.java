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
    * 论坛的消息
    */
@ApiModel(value="论坛的消息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_message")
public class BbsMessage implements Serializable {
    /**
     * 消息主键
     */
    @TableId(value = "message_id", type = IdType.AUTO)
    @ApiModelProperty(value="消息主键")
    private Long messageId;

    /**
     *  通知类型，1动态，2评论，3回复，4私信，99系统通知
     */
    @TableField(value = "tpis_type")
    @ApiModelProperty(value=" 通知类型，1动态，2评论，3回复，4私信，99系统通知")
    private Integer tpisType;

    /**
     * 产生消息的对应内容的主键
     */
    @TableField(value = "message_event_id")
    @ApiModelProperty(value="产生消息的对应内容的主键")
    private Long messageEventId;

    /**
     * 接收方用户ID
     */
    @TableField(value = "sender_user_id")
    @ApiModelProperty(value="接收方用户ID")
    private Long senderUserId;

    /**
     * 接收方用户ID
     */
    @TableField(value = "receiver_user_id")
    @ApiModelProperty(value="接收方用户ID")
    private Long receiverUserId;

    /**
     * 摘要说明
     */
    @TableField(value = "brief")
    @ApiModelProperty(value="摘要说明")
    private String brief;

    /**
     * 详细内容
     */
    @TableField(value = "content")
    @ApiModelProperty(value="详细内容")
    private String content;

    /**
     * 状态 0 未读 1 已读
     */
    @TableField(value = "tips_status")
    @ApiModelProperty(value="状态 0 未读 1 已读")
    private Integer tipsStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 逻辑删除标记位
     */
    @TableField(value = "deleted")
    @ApiModelProperty(value="逻辑删除标记位")
    private Integer deleted;

    private static final long serialVersionUID = 1L;
}