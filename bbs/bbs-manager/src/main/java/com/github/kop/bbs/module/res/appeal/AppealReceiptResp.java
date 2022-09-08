package com.github.kop.bbs.module.res.appeal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/8 22:00
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("申诉回执列表")
@Data
public class AppealReceiptResp {


    /**
     * 申诉回执主键
     */
    @ApiModelProperty(value = "回执主键")
    private Long appealReceiptId;

    /**
     * 申诉主键
     */
    @ApiModelProperty("申诉主键")
    private Long appealId;

    /**
     * 申诉回执顺序
     */
    @ApiModelProperty(value = "`申诉回执顺序`")
    private Integer order;

    /**
     * 官方回复
     */
    @ApiModelProperty(value = "官方回复")
    private String appealOfficialReply;

    /**
     * 用户回复
     */
    @ApiModelProperty(value = "用户回复")
    private String appealUserReply;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
