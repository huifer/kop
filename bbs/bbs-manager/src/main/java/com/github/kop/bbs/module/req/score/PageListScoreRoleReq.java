package com.github.kop.bbs.module.req.score;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/14 16:24
 */
@Api("积分规则的分页查询参数")
@Data
public class PageListScoreRoleReq {

    /**
     * 积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分
     */
    @ApiModelProperty(value = "积分类型  1 签到积分 2 发帖积分 3 评论积分 4 惩罚积分")
    private Integer roleType;

    /**
     * 增减类型  0 减少 1 增加
     */
    @ApiModelProperty(value = "增减类型  0 减少 1 增加")
    private Integer addType;

    /**
     * 积分数量 0 不限
     */
    @ApiModelProperty(value = "积分数量 0 不限 ")
    private Integer score;

    /**
     * 积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年
     */
    @ApiModelProperty(value = "积分周期(周期内只能得一次分) 0 没有周期(即不限制得分)  1 天 2 周 3 月 4 年 ")
    private Integer scoreCycle;

}
