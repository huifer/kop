package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.module.entity.MidUserCategoryVote;
import com.github.kop.bbs.repo.MidUserCategoryVoteRepository;
import com.github.kop.bbs.repo.mapper.MidUserCategoryVoteMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/23 00:10
 */
@Repository
public class MidUserCategoryVoteRepositoryImpl implements MidUserCategoryVoteRepository {

    @Resource
    private MidUserCategoryVoteMapper midUserCategoryVoteMapper;

    @Override
    public MidUserCategoryVote findById(Long voteId) {
        return midUserCategoryVoteMapper.selectById(voteId);
    }
}
