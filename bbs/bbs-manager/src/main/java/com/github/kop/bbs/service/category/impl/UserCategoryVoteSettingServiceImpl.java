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
        LocalDateTime now = LocalDateTime.now();
        if (categoryVoteSetting.getApplyStartTime().isBefore(now)) {
            throw new NoceException("申请时间还没到!");
        }
        // 申请时间结束了
        if (categoryVoteSetting.getApplyEndTime().isAfter(now)) {
            throw new NoceException("申请时间已过!");
        }
        // 申请人数已满
        if (categoryVoteSetting.getApplicationCount() > 0 && Objects.equals(categoryVoteSetting.getAlreadyCount(), categoryVoteSetting.getApplicationCount())) {
            throw new NoceException("申请人数已满!");
        }
        return categoryVoteSetting;
    }

    @Override
    public void verifyTicketTime(Long voteSettingId) {
        UserCategoryVoteSetting categoryVoteSetting = userCategoryVoteSettingRepository.findById(voteSettingId);
        if (ObjectUtils.isEmpty(categoryVoteSetting)) {
            throw new NoceException("该投票不存在!");
        }
        LocalDateTime now = LocalDateTime.now();
        // 申请时间结束了
        if (categoryVoteSetting.getVoteStartTime().isBefore(now)) {
            throw new NoceException("投票还未开始!");
        }
        if (categoryVoteSetting.getVoteStartTime().isAfter(now)) {
            throw new NoceException("投票已经结束了!");
        }
    }

    @Override
    public UserCategoryVoteSetting findStartSetting(Long categoryId) {
        return userCategoryVoteSettingRepository.findStartSetting(categoryId);
    }
}



