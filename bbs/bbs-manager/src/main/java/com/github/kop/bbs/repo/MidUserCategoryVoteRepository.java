package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.MidUserCategoryVote;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/23 00:10
 */
public interface MidUserCategoryVoteRepository {
    MidUserCategoryVote findById(Long voteId);
}
