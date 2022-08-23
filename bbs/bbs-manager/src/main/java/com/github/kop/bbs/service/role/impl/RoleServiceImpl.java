package com.github.kop.bbs.service.role.impl;

import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.repo.RoleRepository;
import com.github.kop.bbs.service.role.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private MidUserRoleRepository midUserRoleRepository;

  @Override
  public Role byCode(String roleCode) {
    return roleRepository.byCode(roleCode);
  }

  @Override
  public List<Role> findByUserId(Long userId) {
    List<Long> roleIds = midUserRoleRepository.byUserId(userId);
    return roleRepository.listById(roleIds);
  }

  @Override
  public boolean hasRoleCodes(List<String> toCheck, Long userId) {
    // 搜索用户拥有的角色id
    List<Long> roleIds = midUserRoleRepository.byUserId(userId);
    // 将角色id和待测角色编码进行联合搜索
    List<Role> roles = this.roleRepository.byCodeAndRoleId(roleIds, toCheck);
    return roles.size() > 0 && (roles.size() <= toCheck.size());
  }

}
