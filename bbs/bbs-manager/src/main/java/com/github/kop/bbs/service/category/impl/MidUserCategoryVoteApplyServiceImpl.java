package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.repo.MidUserCategoryVoteApplyRepository;
import com.github.kop.bbs.service.category.MidUserCategoryVoteApplyService;
import com.github.kop.bbs.service.category.MidUserCategoryVoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MidUserCategoryVoteApplyServiceImpl  implements MidUserCategoryVoteApplyService {

    @Resource
    private MidUserCategoryVoteApplyRepository midUserCategoryVoteApplyRepository;


    @Resource
    private MidUserCategoryVoteService midUserCategoryVoteService;

    /**
     * 申请版主投票
     *
     * @param voteId
     * @param userId
     * @return
     */
    @Override
    public Boolean applyVote(Long voteId, Long userId) {
        // 根据voteId验证投票
        midUserCategoryVoteService.verifyByVoteId(voteId);
        return null;
    }
}



