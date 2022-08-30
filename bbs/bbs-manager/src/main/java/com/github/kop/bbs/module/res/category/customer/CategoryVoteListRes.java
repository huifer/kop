package com.github.kop.bbs.module.res.category.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/30 21:56
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel("版主投票详情")
public class CategoryVoteListRes {

    @ApiModelProperty("版主申请人列表")
    private List<VoteApplyItem> VoteApplyList;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class VoteApplyItem{

        @ApiModelProperty("申请人id")
        private Long userId;

        @ApiModelProperty("申请人昵称")
        private String userName;

        @ApiModelProperty("票数")
        private Long ticketCount;
    }

    @ApiModelProperty("是否可以投票 1 可以 0 不可以")
    private Integer canTicket;

}
