package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import org.apache.ibatis.annotations.Param;

public interface UserCategoryVoteSettingMapper extends BaseMapper<UserCategoryVoteSetting> {
    UserCategoryVoteSetting findVoteStartSetting(@Param("categoryId") Long categoryId);

    UserCategoryVoteSetting findApplyStartSetting(@Param("categoryId") Long categoryId);

    void updateApplyCount(@Param("voteSettingId") Long voteSettingId);
}