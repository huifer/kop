package com.github.kop.bbs.service.category;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:53
 */
public interface MidUserCategoryVoteApplyService {
    boolean addVoteTicket(Long applyId, Long userId);
}
