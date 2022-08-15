package com.github.kop.bbs.module.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.github.kop.bbs.module.enums.ScoreTypeEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class ScoreRole implements Serializable {
    /**
     * 积分规则主键
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    @ApiModelProperty(value = "积分规则主键")
    private Long roleId;

    /**
     * 积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分
     * <p>
     * {@link  ScoreTypeEnums}
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
     * 获取的积分
     */
    @TableField(value = "score")
    @ApiModelProperty(value = "获取的积分")
    private Long score;
    /**
     * 周期内最多获取的积分数量
     */
    @TableField(value = "max_score")
    private Long maxScore;

    /**
     * 积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年
     */
    @TableField(value = "score_cycle")
    @ApiModelProperty(value = "积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ")
    private Integer scoreCycle;

    /**
     * 周期具体数字
     */
    @TableField(value = "cycle_num")
    private Integer cycleNum;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建用户
     */
    @TableField(value = "create_user_id",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建用户")
    private Long createUserId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    /**
     * 更新用户
     */
    @TableField(value = "update_user_id",fill = FieldFill.INSERT_UPDATE)
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
    @Version
    private Long version;

    private static final long serialVersionUID = 1L;
}