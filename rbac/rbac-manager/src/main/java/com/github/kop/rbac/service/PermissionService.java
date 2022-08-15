package com.github.kop.rbac.service;

import com.github.kop.rbac.module.biz.PermissionBiz;

public interface PermissionService {

  /** 生成权限信息 */
  PermissionBiz generatorPermission(Long postId);
}
