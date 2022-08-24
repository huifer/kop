package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.MidUserRole;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 14:42
 */
public interface MidUserRoleRepository {

  /**
   * 添加角色
   *
   * @param build
   */
  int insert(MidUserRole midUserRole);

  /** 验证角色 */
  boolean existsUserRole(Long userId, String roleCode);

  /**
   * 删除用户和角色之间的绑定关系
   *
   * @param userId 用户id
   * @param roleId 角色id
   * @return 受影响行数
   */
  int deleteUserRole(Long userId, Long roleId);

  List<Long> byUserId(Long userId);

  int  insertAll(List<MidUserRole> userRoles);
}
