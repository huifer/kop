package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.BbsUser;
import com.github.kop.bbs.repo.UserRepository;
import com.github.kop.bbs.repo.mapper.BbsUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private BbsUserMapper userMapper;

  @Override
  public long insert(BbsUser build) {
    // todo: 写入前校验
    validateUserName(build);

    int insert = userMapper.insert(build);
    if (insert > 0) {
      return build.getId();
    }
    return -1;
  }

  @Override
  public BbsUser selectById(Long id) {
    if (id == null) {
      throw new RuntimeException("用户id不存在");
    }
    return this.userMapper.selectById(id);
  }

  @Override
  public BbsUser findByName(String username) {
    QueryWrapper<BbsUser> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(BbsUser::getUsername, username);
    return this.userMapper.selectOne(queryWrapper);
  }

  @Override
  public int updateById(BbsUser bbsUser) {
    validateUserName(bbsUser);
    return this.userMapper.updateById(bbsUser);
  }

  private void validateUserName(BbsUser bbsUser) {
    boolean b = existsUserName(bbsUser.getUsername());
    if (b) {
      throw new RuntimeException("用户名已存在");
    }
  }

  @Override
  public boolean existsUserName(String name) {
    QueryWrapper<BbsUser> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(BbsUser::getUsername, name);
    return this.userMapper.exists(queryWrapper);
  }
}
