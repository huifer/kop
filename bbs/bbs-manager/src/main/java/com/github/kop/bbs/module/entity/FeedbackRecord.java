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
 * 用户反馈
 */
@ApiModel(value = "用户反馈")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_feedback_record")
public class FeedbackRecord implements Serializable {
    /**
     * 用户反馈主键
     */
    @TableId(value = "feedback_record_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户反馈主键")
    private Long feedbackRecordId;

    /**
     * 反馈内容
     */
    @TableField(value = "feedback_text")
    @ApiModelProperty(value = "反馈内容")
    private String feedbackText;

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