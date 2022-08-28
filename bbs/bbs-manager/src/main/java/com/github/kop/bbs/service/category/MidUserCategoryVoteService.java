package com.github.kop.bbs.service.category;


import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;

public interface MidUserCategoryVoteService {


    /**
     * 根据voteId验证投票
     *
     * @param voteSettingId
     */
    Integer verifyByVoteId(Long voteSettingId,Long userId);

    boolean applyVote(Long voteSettingId, Long userId);

    MidUserCategoryVoteApply findByApplyId(Long applyId);
}


















