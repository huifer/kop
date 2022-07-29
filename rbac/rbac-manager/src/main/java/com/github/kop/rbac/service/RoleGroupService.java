package com.github.kop.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.role.group.CreateRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.QueryRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.UpdateRoleGroupReq;
import com.github.kop.rbac.module.res.role.group.RoleGroupQueryRes;
import java.util.List;

public interface RoleGroupService {
  int create(CreateRoleGroupReq req);

  int update(UpdateRoleGroupReq req);

  RoleGroupQueryRes byId(Long id);

  int deleteById(Long id);

  IPage<RoleGroupQueryRes> page(Long page, Long size, QueryRoleGroupReq req);

  List<RoleGroupQueryRes> list(QueryRoleGroupReq req);
}
