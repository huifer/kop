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
 * 论坛的帖子评论
 */
@ApiModel(value = "论坛的帖子评论")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "bbs_comment")
public class BbsComment implements Serializable {
    /**
     * 帖子评论主键
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    @ApiModelProperty(value = "帖子评论主键")
    private Long commentId;

    /**
     * 评论类别 1 帖子 2 评论 3 话题
     */
    @TableField(value = "comment_type")
    @ApiModelProperty(value = "评论类别 1 帖子 2 评论 3 话题")
    private Integer commentType;

    /**
     * 回复的内容对应级别的id
     */
    @TableField(value = "event_id")
    @ApiModelProperty(value = "回复的内容对应级别的id")
    private Long eventId;

    /**
     * 回复帖子为空如果是回复评论,整个评论id的层级路径
     */
    @TableField(value = "event_level_path")
    @ApiModelProperty(value = "回复帖子为空如果是回复评论,整个评论id的层级路径")
    private Long eventLevelPath;

    /**
     * 点赞数
     */
    @TableField(value = "thumbs_cont")
    @ApiModelProperty(value = "点赞数")
    private Long thumbsCont;

    /**
     * IP地址
     */
    @TableField(value = "ip")
    @ApiModelProperty(value = "IP地址")
    private String ip;

    /**
     * IP城市地址
     */
    @TableField(value = "ip_loc")
    @ApiModelProperty(value = "IP城市地址")
    private String ipLoc;

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