package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.repo.RoleRepository;
import com.github.kop.bbs.repo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

  @Autowired private RoleMapper roleMapper;

  @Override
  public Role byCode(String roleCode) {
    return roleMapper.byCode(roleCode);
  }
}
