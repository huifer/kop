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
 * 用户积分
 */
@ApiModel(value = "用户积分")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_user_score")
public class UserScore implements Serializable {
    /**
     * 用户总分主键
     */
    @TableId(value = "score_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户总分主键")
    private Long scoreId;

    /**
     * 总分
     */
    @TableField(value = "sum_score")
    @ApiModelProperty(value = "总分")
    private Long sumScore;

    /**
     * 当前的分数
     */
    @TableField(value = "current_score")
    @ApiModelProperty(value = "当前的分数")
    private Long currentScore;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

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

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 更新用户
     */
    @TableField(value = "update_user_id")
    @ApiModelProperty(value = "更新用户")
    private Long updateUserId;

    private static final long serialVersionUID = 1L;
}