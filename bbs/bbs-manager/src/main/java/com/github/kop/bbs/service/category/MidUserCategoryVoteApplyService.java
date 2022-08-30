package com.github.kop.bbs.service.category;

import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import com.github.kop.bbs.module.res.category.customer.CategoryVoteListRes;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:53
 */
public interface MidUserCategoryVoteApplyService {
    boolean applyVote(Long voteSettingId, Long userId);

    /**
     * 验证投票开始时间
     * @param applyId
     */
    MidUserCategoryVoteApply verifyByApplyId(Long applyId);

    /**
     * 根据分类获取进行中的版主投票列表
     * @param categoryId
     * @param userId
     * @return
     */
    CategoryVoteListRes getCategoryVoteList(Long categoryId, Long userId);
}
