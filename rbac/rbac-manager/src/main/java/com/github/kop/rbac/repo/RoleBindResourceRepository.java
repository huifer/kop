package com.github.kop.rbac.repo;

import com.github.kop.rbac.module.entity.RbacRoleBindResource;

import java.util.List;

public interface RoleBindResourceRepository {
    int  create(RbacRoleBindResource rbacRoleBindResource);

    int  delete(RbacRoleBindResource rbacRoleBindResource);

    List<Long> findResourceIds(Long roleId);

    List<Long> findResourceIds(List<Long> roleIds);
}
