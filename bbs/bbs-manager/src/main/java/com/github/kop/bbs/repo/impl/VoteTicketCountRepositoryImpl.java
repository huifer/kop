package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.VoteTicketCount;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.repo.VoteTicketCountRepository;
import com.github.kop.bbs.repo.mapper.VoteTicketCountMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:48
 */
@Repository
public class VoteTicketCountRepositoryImpl implements VoteTicketCountRepository {

    @Resource
    private VoteTicketCountMapper voteTicketCountMapper;

    @Override
    public Long findCountByApplyId(Long applyId) {
        QueryWrapper<VoteTicketCount> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(VoteTicketCount::getApplyId,applyId)
                .eq(VoteTicketCount::getDeleted, DeletedEnum.FALSE.getCode());
        return voteTicketCountMapper.selectCount(queryWrapper);
    }

    @Override
    public int insert(VoteTicketCount build) {
        return voteTicketCountMapper.insert(build);
    }

    /**
     * 投票
     *
     * @param applyId
     * @return
     */
    @Override
    public int addVoteTicket(Long applyId) {
        return voteTicketCountMapper.addVoteTicket(applyId);
    }

    @Override
    public List<VoteTicketCount> findTicketByApplyIds(List<Long> applyIdList) {
        QueryWrapper<VoteTicketCount> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .in(VoteTicketCount::getApplyId,applyIdList)
                .eq(VoteTicketCount::getDeleted, DeletedEnum.FALSE.getCode());
        return voteTicketCountMapper.selectList(queryWrapper);
    }
}
