package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacRole;
import com.github.kop.rbac.module.req.role.QueryRoleReq;
import java.util.List;

public interface RoleRepository {

  /**
   * 确认角色编码是否存在对应数据
   */
  boolean exists(String code);

  RbacRole byId(Long id);

  int create(RbacRole rbacRole);

  int update(RbacRole rbacRole);

  int delete(Long id);

  List<RbacRole> list(QueryRoleReq req);

  IPage<RbacRole> page(Long page, Long size, QueryRoleReq req);
}
