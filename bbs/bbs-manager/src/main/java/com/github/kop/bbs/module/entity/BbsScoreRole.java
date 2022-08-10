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
 * 论坛的积分规则配置
 */
@ApiModel(value = "论坛的积分规则配置")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_score_role")
public class BbsScoreRole implements Serializable {
    /**
     * 积分规则主键
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    @ApiModelProperty(value = "积分规则主键")
    private Long roleId;

    /**
     * 积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分
     */
    @TableField(value = "role_type")
    @ApiModelProperty(value = "积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分")
    private Integer roleType;

    /**
     * 增减类型  0 减少 1 增加
     */
    @TableField(value = "add_type")
    @ApiModelProperty(value = "增减类型  0 减少 1 增加")
    private Integer addType;

    /**
     * 积分数量 0 不限
     */
    @TableField(value = "score")
    @ApiModelProperty(value = "积分数量 0 不限 ")
    private Integer score;

    /**
     * 积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年
     */
    @TableField(value = "score_cycle")
    @ApiModelProperty(value = "积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ")
    private Integer scoreCycle;

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