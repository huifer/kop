package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.repo.VoteTicketLogRepository;
import com.github.kop.bbs.repo.mapper.VoteTicketLogMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:47
 */
@Repository
public class VoteTicketLogRepositoryImpl implements VoteTicketLogRepository {

    @Resource
    private VoteTicketLogMapper voteTicketLogMapper;

}
