package com.github.kop.bbs.module.enums.role;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @auth ahxiaoqi
 * @desc 角色枚举
 * @time 2022/8/13 14:27
 */
@AllArgsConstructor
@Getter
public enum RoleEnum {
  ROOT(1L, "超级管理员", "root"),

  ADMIN(2L, "管理员", "admin"),

  WEBMASTER(3L, "版主", "webmaster"),

  USER(4L, "普通用户", "user"),
  ;

  /** 角色id */
  private final Long roleId;

  /** 角色名称 */
  private final String roleName;

  /** 角色名称 */
  private final String roleCode;
}
