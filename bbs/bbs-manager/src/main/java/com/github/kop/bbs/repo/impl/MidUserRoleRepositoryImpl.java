package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.repo.mapper.MidUserRoleMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 14:43
 */
@Repository
public class MidUserRoleRepositoryImpl implements MidUserRoleRepository {

  @Resource private MidUserRoleMapper bbsMidUserRoleMapper;

  /**
   * 添加角色
   *
   * @param midUserRole
   */
  @Override
  @Transactional(rollbackFor = {Exception.class})
  public int insert(MidUserRole midUserRole) {
    validateUserRole(midUserRole.getUserId(), midUserRole.getRoleCode());
    return bbsMidUserRoleMapper.insert(midUserRole);
  }

  private void validateUserRole(Long userId, String roleCode) {
    if (existsUserRole(userId, roleCode)) {
      throw new NoceException("当前用户角色已存在");
    }
  }

  /** 验证角色 */
  public boolean existsUserRole(Long userId, String roleCode) {
    QueryWrapper<MidUserRole> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(MidUserRole::getRoleCode, roleCode).eq(MidUserRole::getUserId, userId);
    return bbsMidUserRoleMapper.exists(queryWrapper);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int deleteUserRole(Long userId, Long roleId) {
    return bbsMidUserRoleMapper.deleteUserRole(userId, roleId);
  }

  @Override
  public List<Long> byUserId(Long userId) {
    return bbsMidUserRoleMapper.byUserId(userId);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int insertAll(List<MidUserRole> userRoles) {

    int i = 0;
    for (MidUserRole userRole : userRoles) {

      i = i + insert(userRole);
    }
    return i;
  }

  @Override
  public List<Long> findByUserId(Long userId) {
    return this.bbsMidUserRoleMapper.findByUserId(userId);
  }

  /**
   * 根据角色获取
   *
   * @param roleCode
   * @return
   */
  @Override
  public List<MidUserRole> findByRole(String roleCode) {
    QueryWrapper<MidUserRole> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(MidUserRole::getRoleCode, roleCode);
    return bbsMidUserRoleMapper.selectList(queryWrapper);
  }
}
