package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.UserFollowerList;
import com.github.kop.bbs.repo.UserFollowerListRepository;
import com.github.kop.bbs.repo.mapper.UserFollowerListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserFollowerListRepositoryImpl implements UserFollowerListRepository {

  @Autowired
  private UserFollowerListMapper userFollowerListMapper;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(UserFollowerList userFollowerList) {
    return userFollowerListMapper.insert(userFollowerList);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int deleteByUserIdAndTargetUserId(Long userId, Long targetUserId) {
    QueryWrapper<UserFollowerList> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(UserFollowerList::getCreateUserId, userId)
        .eq(UserFollowerList::getFollowerUserId, targetUserId);
    return userFollowerListMapper.delete(queryWrapper);
  }

  @Override
  public IPage<UserFollowerList> page(Long userId, Long page, Long size) {
    QueryWrapper<UserFollowerList> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(UserFollowerList::getCreateUserId, userId);
    return this.userFollowerListMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}
