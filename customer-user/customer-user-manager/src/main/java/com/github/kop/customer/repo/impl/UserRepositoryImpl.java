package com.github.kop.customer.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.customer.module.entity.CustomerUser;
import com.github.kop.customer.repo.UserRepository;
import com.github.kop.customer.repo.mapper.CustomerUserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRepositoryImpl implements UserRepository {
  @Autowired private CustomerUserMapper userMapper;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(CustomerUser customerUser) {
    return userMapper.insert(customerUser);
  }

  @Override
  public CustomerUser byId(long userId) {
    return this.userMapper.selectById(userId);
  }

  @Override
  public IPage<CustomerUser> page(long cur, long size) {
    QueryWrapper<CustomerUser> queryWrapper = new QueryWrapper<>();
    return userMapper.selectPage(new Page<>(cur, size), queryWrapper);
  }

  /**
   * @param cur
   * @param size
   * @param uids 用户id
   * @return
   */
  @Override
  public IPage<CustomerUser> page(long cur, long size, List<Long> uids) {
    QueryWrapper<CustomerUser> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().in(CustomerUser::getId, uids);
    return userMapper.selectPage(new Page<>(cur, size), queryWrapper);
  }
}
