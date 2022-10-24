package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.req.category.voteSettingListReq;
import com.github.kop.bbs.repo.UserCategoryVoteSettingRepository;
import com.github.kop.bbs.repo.mapper.UserCategoryVoteSettingMapper;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/23 00:10
 */
@Repository
public class UserCategoryVoteSettingImpl implements UserCategoryVoteSettingRepository {

  @Resource private UserCategoryVoteSettingMapper midUserCategoryVoteMapper;

  @Override
  public UserCategoryVoteSetting findById(Long voteId) {
    return midUserCategoryVoteMapper.selectById(voteId);
  }

  /**
   * 获取投票时间有效的设置
   *
   * @param categoryId
   * @return
   */
  @Override
  public UserCategoryVoteSetting findVoteStartSetting(Long categoryId) {
    return midUserCategoryVoteMapper.findVoteStartSetting(categoryId);
  }

  @Override
  public int insert(UserCategoryVoteSetting build) {
    UserCategoryVoteSetting startSetting = findVoteStartSetting(build.getCategoryId());
    if (ObjectUtils.isNotEmpty(startSetting)) {
      throw new NoceException("当前版块有正在进行中的投票!");
    }
    return midUserCategoryVoteMapper.insert(build);
  }

  /**
   * 获取申请时间有效的设置
   *
   * @param categoryId
   * @return
   */
  @Override
  public UserCategoryVoteSetting findApplyStartSetting(Long categoryId) {
    return midUserCategoryVoteMapper.findApplyStartSetting(categoryId);
  }

  /**
   * 更新申请人数
   *
   * @param voteSettingId
   */
  @Override
  public void updateApplyCount(Long voteSettingId) {
    midUserCategoryVoteMapper.updateApplyCount(voteSettingId);
  }

  @Override
  public IPage<UserCategoryVoteSetting> voteSettingList(
      Long categoryId, Integer orderType, Integer page, Integer pageSize) {
    QueryWrapper<UserCategoryVoteSetting> queryWrapper = new QueryWrapper<>();
    LambdaQueryWrapper<UserCategoryVoteSetting> eq =
        queryWrapper
            .lambda()
            .eq(UserCategoryVoteSetting::getCategoryId, categoryId)
            .eq(UserCategoryVoteSetting::getDeleted, DeletedEnum.FALSE.getCode());
    if (voteSettingListReq.voteSettingListOrderType.APPLY_TIME.getCode().equals(orderType)) {
      eq.orderByDesc(UserCategoryVoteSetting::getApplyEndTime);
    } else if (voteSettingListReq.voteSettingListOrderType.VOTE_TIME.getCode().equals(orderType)) {
      eq.orderByDesc(UserCategoryVoteSetting::getVoteEndTime);
    }
    return midUserCategoryVoteMapper.selectPage(new Page<>(page, pageSize), queryWrapper);
  }
}
