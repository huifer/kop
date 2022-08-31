package com.github.kop.bbs.module.req.invitation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/31 22:23
 */
@ApiModel("帖子评论")
@Data
public class InvitationCommentReq {

    /**
     * 主体id
     */
    @ApiModelProperty(value = "主体id")
    private Long refId;

    /**
     * 评论类别 1 帖子 2 帖子评论
     */
    @ApiModelProperty(value = "评论类别")
    private Integer invitationCommentType;

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
