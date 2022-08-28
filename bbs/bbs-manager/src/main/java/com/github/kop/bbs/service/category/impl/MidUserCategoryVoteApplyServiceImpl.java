package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.MidUserCategoryVoteApplyRepository;
import com.github.kop.bbs.service.category.MidUserCategoryVoteApplyService;
import com.github.kop.bbs.service.category.MidUserCategoryVoteService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:53
 */
@Service
public class MidUserCategoryVoteApplyServiceImpl implements MidUserCategoryVoteApplyService {

    @Resource
    private MidUserCategoryVoteApplyRepository midUserCategoryVoteApplyRepository;

    @Resource
    private MidUserCategoryVoteService midUserCategoryVoteService;

    @Override
    public boolean addVoteTicket(Long applyId, Long userId) {
        MidUserCategoryVoteApply byApplyId = midUserCategoryVoteService.findByApplyId(applyId);
        if(ObjectUtils.isEmpty(byApplyId)){
            throw new NoceException("当前版主申请不存在");
        }
        // TODO: 2022/8/28 添加投票记录,记录投票
        return false;
    }
}
