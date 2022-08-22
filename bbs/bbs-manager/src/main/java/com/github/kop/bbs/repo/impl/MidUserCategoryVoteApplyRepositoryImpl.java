package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.repo.MidUserCategoryVoteApplyRepository;
import com.github.kop.bbs.repo.mapper.MidUserCategoryVoteApplyMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/22 23:39
 */
@Repository
public class MidUserCategoryVoteApplyRepositoryImpl implements MidUserCategoryVoteApplyRepository {

    @Resource
    private MidUserCategoryVoteApplyMapper midUserCategoryVoteApplyMapper;

}
