package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.repo.VoteTicketCountRepository;
import com.github.kop.bbs.repo.mapper.VoteTicketCountMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:48
 */
@Repository
public class VoteTicketCountRepositoryImpl implements VoteTicketCountRepository {

    @Resource
    private VoteTicketCountMapper voteTicketCountMapper;

}
