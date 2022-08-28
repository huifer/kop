package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.UserCategoryVoteSettingRepository;
import com.github.kop.bbs.service.category.UserCategoryVoteSettingService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class UserCategoryVoteSettingServiceImpl implements UserCategoryVoteSettingService {

    @Resource
    private UserCategoryVoteSettingRepository userCategoryVoteSettingRepository;


    @Override
    public UserCategoryVoteSetting verifyByVoteId(Long voteSettingId) {
        UserCategoryVoteSetting categoryVoteSetting = userCategoryVoteSettingRepository.findById(voteSettingId);
        if (ObjectUtils.isEmpty(categoryVoteSetting)) {
            throw new NoceException("该投票不存在!");
        }
        // 申请时间结束了
        if (categoryVoteSetting.getApplyEndTime().isAfter(LocalDateTime.now())) {
            throw new NoceException("申请时间已过!");
        }
        // 申请人数已满
        if (categoryVoteSetting.getApplicationCount() > 0 && Objects.equals(categoryVoteSetting.getAlreadyCount(), categoryVoteSetting.getApplicationCount())) {
            throw new NoceException("申请人数已满!");
        }
        return categoryVoteSetting;
    }
}



