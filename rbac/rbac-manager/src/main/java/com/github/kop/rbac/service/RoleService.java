package com.github.kop.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.role.CreateRoleReq;
import com.github.kop.rbac.module.req.role.QueryRoleReq;
import com.github.kop.rbac.module.req.role.UpdateRoleReq;
import com.github.kop.rbac.module.res.role.RoleQueryRes;
import java.util.List;

public interface RoleService {
  List<RoleQueryRes> list(QueryRoleReq req);

  int create(CreateRoleReq req);

  int update(UpdateRoleReq req);

  RoleQueryRes byId(Long id);

  int deleteById(Long id);

  IPage<RoleQueryRes> page(Long page, Long size, QueryRoleReq req);
}
