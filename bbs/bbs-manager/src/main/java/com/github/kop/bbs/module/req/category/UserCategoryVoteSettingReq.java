package com.github.kop.bbs.module.req.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 08:23
 */
@ApiModel("版主设置请求参数")
@Data
public class UserCategoryVoteSettingReq {


    /**
     * 版块id
     */
    @ApiModelProperty(value = "版块id")
    private Long categoryId;

    /**
     * 申请人数限制 0 不限制
     */
    @ApiModelProperty(value = "申请人数限制 0 不限制")
    private Long applicationCount;

    /**
     * 申请开始时间(时间范围内允许申请)
     */
    @ApiModelProperty(value = "申请开始时间(时间范围内允许申请)")
    private LocalDateTime applyStartTime;

    /**
     * 申请结束时间
     */
    @ApiModelProperty(value = "申请结束时间")
    private LocalDateTime applyEndTime;

    /**
     * 投票开始时间(时间范围内允许投票)
     */
    @ApiModelProperty(value = "投票开始时间(时间范围内允许投票)")
    private LocalDateTime voteStartTime;

    /**
     * 投票结束时间
     */
    @ApiModelProperty(value = "投票结束时间")
    private LocalDateTime voteEndTime;
}
