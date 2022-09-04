package com.github.kop.bbs.module.res.category.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/4 08:57
 */
@ApiModel("用户根据版块获取的版主申请设置返回值")
@Data
public class CustomerUserCategoryVoteSettingRes {


    /**
     * 版块id
     */
    @ApiModelProperty(value = "版块id")
    private Long categoryId;

    /**
     * 申请人数限制 0 不限制
     */
    @ApiModelProperty(value = "申请人数限制 0 不限制")
    private String applicationCount;

    /**
     * 已经申请的人
     */
    @ApiModelProperty(value = "已经申请的人")
    private Long alreadyCount;

    /**
     * 申请开始时间(时间范围内允许申请)
     */
    @ApiModelProperty(value = "申请开始时间")
    private LocalDateTime applyStartTime;

    /**
     * 申请结束时间
     */
    @ApiModelProperty(value = "申请结束时间")
    private LocalDateTime applyEndTime;

    /**
     * 投票开始时间(时间范围内允许投票)
     */
    @ApiModelProperty(value = "投票开始时间")
    private LocalDateTime voteStartTime;

    /**
     * 投票结束时间
     */
    @ApiModelProperty(value = "投票结束时间")
    private LocalDateTime voteEndTime;
}
