package com.github.kop.bbs.service.user;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.req.user.UserBindRoleReq;
import com.github.kop.bbs.module.res.role.RoleListResp;
import java.util.List;

/**
 * 用户角色中间表 服务类
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
public interface MidUserRoleService {

  /**
   * 添加角色
   *
   * @param build
   */
  void addUserRole(MidUserRole build);

  /** 验证角色 */
  boolean existsUserRole(Long userId, String roleCode);

  /**
   * 删除角色
   *
   * @param userId 用户id
   * @param roleId 角色id
   * @return
   */
  boolean deleteUserRole(Long userId, Long roleId);

  /**
   * 赋予角色
   *
   * @param userId 操作人id
   * @param userBindRoleReq 赋予角色参数
   */
  boolean giveRole(Long userId, UserBindRoleReq userBindRoleReq);

  /** 查看用户所有角色 */
  List<RoleListResp> userRoleList(Long userId);

  /**
   * 移除角色
   *
   * @param userId 操作人id
   * @param userBindRoleReq 移除角色参数
   */
  boolean removeRole(Long userId, UserBindRoleReq userBindRoleReq);

  /**
   * 根据角色获取
   *
   * @param roleCode
   * @return
   */
  List<MidUserRole> findByRole(String roleCode);
}
