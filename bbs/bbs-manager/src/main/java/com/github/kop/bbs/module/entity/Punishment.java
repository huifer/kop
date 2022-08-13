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
 * 论坛的惩罚
 */
@ApiModel(value = "论坛的惩罚")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_punishment")
public class Punishment implements Serializable {
    /**
     * 积分惩罚主键
     */
    @TableId(value = "punishment_id", type = IdType.AUTO)
    @ApiModelProperty(value = "积分惩罚主键")
    private Long punishmentId;

    /**
     * 惩罚用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "惩罚用户id")
    private Long userId;

    /**
     * 惩罚依据
     */
    @TableField(value = "punishment_basis")
    @ApiModelProperty(value = "惩罚依据")
    private String punishmentBasis;

    /**
     * 惩罚分数
     */
    @TableField(value = "score_count")
    @ApiModelProperty(value = "惩罚分数")
    private Integer scoreCount;

    /**
     * 惩罚状态 0 未惩罚 1 已惩罚 3 已撤销
     */
    @TableField(value = "punishment_status")
    @ApiModelProperty(value = "惩罚状态 0 未惩罚 1 已惩罚 3 已撤销")
    private Integer punishmentStatus;

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

    /**
     * 逻辑删除标记位
     */
    @TableField(value = "deleted")
    @ApiModelProperty(value = "逻辑删除标记位")
    private Integer deleted;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    @ApiModelProperty(value = "乐观锁")
    private Long version;

    private static final long serialVersionUID = 1L;
}