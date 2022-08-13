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
 * 论坛的申诉
 */
@ApiModel(value = "论坛的申诉")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_appeal")
public class Appeal implements Serializable {
    /**
     * 申诉主键
     */
    @TableId(value = "appeal_id", type = IdType.AUTO)
    @ApiModelProperty(value = "申诉主键")
    private Long appealId;

    /**
     * 申诉类别 1 账号申诉 2 帖子申诉
     */
    @TableField(value = "appeal_type")
    @ApiModelProperty(value = "申诉类别 1 账号申诉 2 帖子申诉")
    private Long appealType;

    /**
     * 申诉标题
     */
    @TableField(value = "appeal_title")
    @ApiModelProperty(value = "申诉标题")
    private String appealTitle;

    /**
     * 申诉描述
     */
    @TableField(value = "appeal_text")
    @ApiModelProperty(value = "申诉描述")
    private String appealText;

    /**
     * 申诉附件
     */
    @TableField(value = "appeal_file")
    @ApiModelProperty(value = "申诉附件")
    private String appealFile;

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