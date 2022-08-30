package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.req.user.UserQueryReq;
import com.github.kop.bbs.repo.UserRepository;
import com.github.kop.bbs.repo.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired private UserMapper userMapper;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public long insert(User build) {
    validateUserName(build);
    int insert = userMapper.insert(build);
    if (insert > 0) {
      return build.getId();
    }
    return -1;
  }

  @Override
  public User selectById(Long id) {
    if (id == null) {
      throw new RuntimeException("用户id不存在");
    }
    return this.userMapper.selectById(id);
  }

  @Override
  public User findByName(String username) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(User::getUsername, username);
    return this.userMapper.selectOne(queryWrapper);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public int updateById(User user) {
    validateUserName(user);
    return this.userMapper.updateById(user);
  }

  private void validateUserName(User user) {
    boolean b = existsUserName(user.getUsername());
    if (b) {
      throw new RuntimeException("用户名已存在");
    }
  }

  @Override
  public boolean existsUserName(String name) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(User::getUsername, name);
    return this.userMapper.exists(queryWrapper);
  }

  @Override
  public IPage<User> page(Long page, Long size, UserQueryReq req) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(StringUtils.isNotBlank(req.getUsername()), User::getUsername, req.getUsername())
        .like(StringUtils.isNotBlank(req.getNickname()), User::getNickname, req.getNickname())
        .between(
            req.getRegisterStartTime() != null && req.getRegisterEndTime() != null,
            User::getRegisterTime,
            req.getRegisterStartTime(), req.getRegisterEndTime()
        )
    ;
    return this.userMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public List<User> findByUserIds(List<Long> userIdList) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
            .in(User::getId, userIdList);
    return userMapper.selectList(queryWrapper);
  }
}
