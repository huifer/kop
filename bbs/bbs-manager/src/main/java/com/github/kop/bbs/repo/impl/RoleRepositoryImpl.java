package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.repo.RoleRepository;
import com.github.kop.bbs.repo.mapper.RoleMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

  @Autowired private RoleMapper roleMapper;

  @Override
  public Role byCode(String roleCode) {
    return roleMapper.byCode(roleCode);
  }

  @Override
  public List<Role> listById(List<Long> roleIds) {
    QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().in(Role::getRoleId, roleIds);
    return roleMapper.selectList(queryWrapper);
  }

  @Override
  public List<Role> byCodeAndRoleId(List<Long> roleIds, List<String> roleCode) {
    QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().in(Role::getRoleId, roleIds).in(Role::getRoleCode, roleCode);
    return roleMapper.selectList(queryWrapper);
  }

  @Override
  public List<Role> list() {
    QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
    return this.roleMapper.selectList(queryWrapper);
  }
}
