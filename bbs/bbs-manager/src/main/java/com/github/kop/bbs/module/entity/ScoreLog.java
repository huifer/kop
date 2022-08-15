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
 * 论坛的积分日志
 * fixme: 和ScoreRecord是否冲突
 */
@ApiModel(value = "论坛的积分日志")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_score_log")
public class ScoreLog implements Serializable {
    /**
     * 积分日志主键
     */
    @TableId(value = "score_log_id", type = IdType.AUTO)
    @ApiModelProperty(value = "积分日志主键")
    private Long scoreLogId;

    /**
     * 积分规则
     */
    @TableField(value = "role_id")
    @ApiModelProperty(value = "积分规则")
    private Long roleId;

    /**
     * 具体加的分数
     */
    @TableField(value = "score_count")
    @ApiModelProperty(value = "具体加的分数")
    private Integer scoreCount;

    /**
     * 事件id
     */
    @TableField(value = "event_id")
    @ApiModelProperty(value = "事件id")
    private Long eventId;

    /**
     * 返回内容
     */
    @TableField(value = "return_msg")
    @ApiModelProperty(value = "返回内容")
    private String returnMsg;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user_id")
    @ApiModelProperty(value = "创建用户")
    private Long createUserId;

    private static final long serialVersionUID = 1L;
}