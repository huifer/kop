package com.github.kop.bbs.module.req.topic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/1 23:05
 */
@ApiModel("评论对象")
@Data
public class TopicCommentReq {

    /**
     * 主体id
     */
    @ApiModelProperty(value = "主体id")
    private Long refId;

    /**
     * 评论类别 1 帖子 2 帖子评论
     */
    @ApiModelProperty(value = "评论类别")
    private Integer topicCommentType;

    @ApiModelProperty(value = "评论内容")
    private Long commentContent;

    /**
     * 上级id
     */
    @ApiModelProperty(value = "上级id")
    private Long pid;

    /**
     * 最上级id
     */
    @ApiModelProperty(value = "最上级id")
    private Long topId;



}
