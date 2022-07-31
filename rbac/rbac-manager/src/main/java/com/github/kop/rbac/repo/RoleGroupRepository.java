package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacRoleGroup;
import com.github.kop.rbac.module.req.role.group.QueryRoleGroupReq;
import java.util.List;

public interface RoleGroupRepository {

  boolean exists(String name);

  RbacRoleGroup byId(Long id);

  int create(RbacRoleGroup rbacRoleGroup);

  int update(RbacRoleGroup rbacRoleGroup);

  int delete(Long id);

  IPage<RbacRoleGroup> page(Long page, Long size, QueryRoleGroupReq req);

  List<RbacRoleGroup> list(QueryRoleGroupReq req);
}
