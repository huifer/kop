package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/23 00:10
 */
public interface UserCategoryVoteSettingRepository {
  UserCategoryVoteSetting findById(Long voteSettingId);

  UserCategoryVoteSetting findVoteStartSetting(Long categoryId);

  int insert(UserCategoryVoteSetting build);

  UserCategoryVoteSetting findApplyStartSetting(Long categoryId);

  void updateApplyCount(Long voteSettingId);

  IPage<UserCategoryVoteSetting> voteSettingList(
      Long categoryId, Integer orderType, Integer page, Integer pageSize);
}
