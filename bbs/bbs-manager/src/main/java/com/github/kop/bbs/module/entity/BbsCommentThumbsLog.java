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
 * 评论的点赞日志
 */
@ApiModel(value = "评论的点赞日志")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_comment_thumbs_log")
public class BbsCommentThumbsLog implements Serializable {
    /**
     * 点赞日志主键
     */
    @TableId(value = "thumbs_log_id", type = IdType.AUTO)
    @ApiModelProperty(value = "点赞日志主键")
    private Long thumbsLogId;

    /**
     * 帖子评论主键
     */
    @TableField(value = "comment_id")
    @ApiModelProperty(value = "帖子评论主键")
    private Long commentId;

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