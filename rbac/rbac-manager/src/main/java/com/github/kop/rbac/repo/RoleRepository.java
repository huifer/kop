package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacRole;

public interface RoleRepository {

  /**
   * 确认角色编码是否存在对应数据
   */
  boolean exists(String code);

  RbacRole byId(Long id);
}
