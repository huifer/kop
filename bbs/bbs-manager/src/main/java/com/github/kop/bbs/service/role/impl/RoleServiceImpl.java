package com.github.kop.bbs.service.role.impl;

import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.module.res.role.RoleListResp;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.repo.RoleRepository;
import com.github.kop.bbs.service.role.RoleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired private RoleRepository roleRepository;

  @Autowired private MidUserRoleRepository midUserRoleRepository;

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

  @Override
  public List<RoleListResp> list() {
    List<Role> roles = this.roleRepository.list();
    List<RoleListResp> res = new ArrayList<>(roles.size());
    for (Role role : roles) {
      RoleListResp e = new RoleListResp();
      e.setRoleId(role.getRoleId());
      e.setRoleName(role.getRoleName());
      e.setRoleCode(role.getRoleCode());
      res.add(e);
    }

    return res;
  }

  @Override
  public List<Role> findByIds(List<Long> roleIds) {
    return this.roleRepository.listById(roleIds);
  }
}
