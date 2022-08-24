package com.github.kop.bbs.service.user.impl;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.module.req.user.UserBindRoleReq;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.service.role.RoleService;
import com.github.kop.bbs.service.user.MidUserRoleService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户角色中间表 服务实现类
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Service
public class MidUserRoleServiceImpl implements MidUserRoleService {

  @Resource private MidUserRoleRepository midUserRoleRepository;

  @Autowired
  private RoleService roleService;

  /** 验证角色 */
  @Override
  public boolean existsUserRole(Long userId, String roleCode) {
    return midUserRoleRepository.existsUserRole(userId, roleCode);
  }

  /**
   * 添加角色
   *
   * @param build
   */
  @Transactional(rollbackFor = {Exception.class})
  @Override
  public void addUserRole(MidUserRole build) {
    midUserRoleRepository.insert(build);
  }

  /**
   * 删除角色
   *
   * @param build
   */
  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean deleteUserRole(Long userId, Long roleId) {
    return midUserRoleRepository.deleteUserRole(userId, roleId) > 0;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean giveRole(Long userId, UserBindRoleReq userBindRoleReq) {
    List<MidUserRole> userRoles = new ArrayList<>();
    for (Long roleId : userBindRoleReq.getRoleIds()) {
      MidUserRole e = new MidUserRole();
      e.setUserId(userBindRoleReq.getUserId());
      e.setRoleId(roleId);
      e.setCreateUserId(userId);
      userRoles.add(e);
    }

    return this.midUserRoleRepository.insertAll(userRoles) > 0;
  }
}
