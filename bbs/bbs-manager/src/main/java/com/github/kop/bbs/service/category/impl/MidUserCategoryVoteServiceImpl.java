package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.MidUserCategoryVote;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.MidUserCategoryVoteRepository;
import com.github.kop.bbs.service.category.MidUserCategoryVoteService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class MidUserCategoryVoteServiceImpl implements MidUserCategoryVoteService {


    @Resource
    private MidUserCategoryVoteRepository midUserCategoryVoteRepository;

    /**
     * 根据voteId验证投票
     *
     * @param voteId
     */
    @Override
    public void verifyByVoteId(Long voteId) {
        MidUserCategoryVote midUserCategoryVote = midUserCategoryVoteRepository.findById(voteId);
        if (ObjectUtils.isEmpty(midUserCategoryVote)) {
            throw new NoceException("该投票不存在!");
        }
        // 申请时间结束了
        if (midUserCategoryVote.getApplyEndTime().isAfter(LocalDateTime.now())) {
            throw new NoceException("申请时间已过!");
        }
        // 申请人数已满
        if (midUserCategoryVote.getApplicationCount() > 0 && Objects.equals(midUserCategoryVote.getAlreadyCount(), midUserCategoryVote.getApplicationCount())) {
            throw new NoceException("申请人数已满!");
        }
        // TODO: 2022/8/23 校验重复申请
    }
}


















