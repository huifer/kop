package com.github.kop.bbs.service.impl;

import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.repo.RoleRepository;
import com.github.kop.bbs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public Role byCode(String roleCode) {
    return roleRepository.byCode(roleCode);
  }
}
