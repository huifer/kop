package com.github.kop.rbac.service;

import java.util.List;

public interface RoleBindService {
  boolean bindGroup(Long roleId, Long roleGroupId);

  boolean bindResource(Long roleId, Long resourceId);

  boolean unBindGroup(Long roleId, Long roleGroupId);

  boolean unBindResource(Long roleId, Long resourceId);

  List<Long> findRoleIds(Long roleGroupId);

  List<Long> findRoleIds(List<Long> roleGroupIds);

  List<Long> findResourceIds(Long roleId);

  List<Long> findResourceIds(List<Long> roleIds);


}
