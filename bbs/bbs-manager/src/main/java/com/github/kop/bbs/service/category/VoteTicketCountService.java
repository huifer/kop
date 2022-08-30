package com.github.kop.bbs.service.category;

import com.github.kop.bbs.module.entity.VoteTicketCount;

import java.util.List;

public interface VoteTicketCountService{

    /**
     * 插入记录日志
     * @param build
     * @return
     */
    int insert(VoteTicketCount build);

    /**
     * 投票
     * @param applyId
     * @param userId
     * @return
     */
    Boolean addVoteTicket(Long applyId, Long userId);

    List<VoteTicketCount> findTicketByApplyIds(List<Long> applyIdList);
}
