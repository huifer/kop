package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.VoteTicketLog;

import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:47
 */
public interface VoteTicketLogRepository {
    int insert(VoteTicketLog build);

    List<VoteTicketLog> findByUserIdAndApplyIdList(List<Long> applyIdList, Long userId);
}
