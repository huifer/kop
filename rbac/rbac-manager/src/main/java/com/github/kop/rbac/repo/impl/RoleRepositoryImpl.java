package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.rbac.module.entity.RbacRole;
import com.github.kop.rbac.repo.RoleRepository;
import com.github.kop.rbac.repo.mapper.RbacRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

  @Autowired
  private RbacRoleMapper rbacRoleMapper;

  @Override
  public boolean exists(String code) {
    QueryWrapper<RbacRole> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(RbacRole::getCode, code);
    return rbacRoleMapper.exists(queryWrapper);
  }

  @Override
  public RbacRole byId(Long id) {
    return this.rbacRoleMapper.selectById(id);
  }
}
