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
 * 话题
 */
@ApiModel(value = "话题")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_topic")
public class BbsTopic implements Serializable {
    /**
     * 话题主键
     */
    @TableId(value = "topic_id", type = IdType.AUTO)
    @ApiModelProperty(value = "话题主键")
    private Long topicId;

    /**
     * 话题标题
     */
    @TableField(value = "topic_title")
    @ApiModelProperty(value = "话题标题")
    private String topicTitle;

    /**
     * 话题内容
     */
    @TableField(value = "topic_content")
    @ApiModelProperty(value = "话题内容")
    private String topicContent;

    /**
     * 话题状态 0 待审核  1 审核通过 2 审核不通过
     */
    @TableField(value = "topic_status")
    @ApiModelProperty(value = "话题状态 0 待审核  1 审核通过 2 审核不通过 ")
    private Integer topicStatus;

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