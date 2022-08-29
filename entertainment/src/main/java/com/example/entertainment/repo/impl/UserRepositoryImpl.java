package com.example.entertainment.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entertainment.module.entity.Users;
import com.example.entertainment.module.manager.req.user.ManagerUserQueryReq;
import com.example.entertainment.repo.UserRepository;
import com.example.entertainment.repo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = {Exception.class})
@Repository
public class UserRepositoryImpl implements UserRepository {

  @Autowired
  private UsersMapper usersMapper;

  @Override
  public boolean hasInvitationCode(String code) {
    QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(Users::getUuid, code);
    return usersMapper.exists(queryWrapper);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(Users users) {
    return this.usersMapper.insert(users);
  }


  @Override
  public Users findByUuid(String uuid) {
    QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(Users::getUuid, uuid);
    return usersMapper.selectOne(queryWrapper);
  }

  @Override
  public Users findByPhone(String phone) {
    QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(Users::getPhone, phone);
    return usersMapper.selectOne(queryWrapper);
  }

  @Override
  public Users findById(int userId) {
    return this.usersMapper.selectById(userId);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int updateById(Users users) {
    return usersMapper.updateById(users);
  }

  @Override
  public IPage<Users> page(int page, int size, ManagerUserQueryReq req) {
    QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(Users::getNickName, req.getNickName())
        .like(Users::getUuid, req.getUuid())
        .like(Users::getPhone, req.getPhone())
        .like(Users::getParentPhone, req.getParentPhone())

    ;
    return this.usersMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}
