package com.github.kop.bbs.service.category;


public interface MidUserCategoryVoteService {


    /**
     * 根据voteId验证投票
     *
     * @param voteSettingId
     */
    Integer verifyByVoteId(Long voteSettingId,Long userId);

    boolean applyVote(Long voteSettingId, Long userId);
}


















