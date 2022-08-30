package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/23 00:10
 */
public interface UserCategoryVoteSettingRepository {
    UserCategoryVoteSetting findById(Long voteSettingId);

    UserCategoryVoteSetting findStartSetting(Long categoryId);
}
