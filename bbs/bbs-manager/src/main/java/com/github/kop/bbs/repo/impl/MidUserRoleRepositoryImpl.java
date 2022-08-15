package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.repo.mapper.MidUserRoleMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 14:43
 */
@Repository
public class MidUserRoleRepositoryImpl implements MidUserRoleRepository {

    @Resource
    private MidUserRoleMapper bbsMidUserRoleMapper;

    /**
     * 添加角色
     *
     * @param midUserRole
     */
    @Override
    public int insert(MidUserRole midUserRole) {
        validateUserRole(midUserRole.getUserId(), midUserRole.getRoleCode());
        return bbsMidUserRoleMapper.insert(midUserRole);
    }

    private void validateUserRole(Long userId, String roleCode) {
        if (existsUserRole(userId, roleCode)) {
            throw new NoceException("当前用户角色已存在");
        }
    }

    /**
     * 验证角色
     */
    public boolean existsUserRole(Long userId, String roleCode) {
        QueryWrapper<MidUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            .eq(MidUserRole::getRoleCode, roleCode)
            .eq(MidUserRole::getUserId, userId);
        return bbsMidUserRoleMapper.exists(queryWrapper);
    }

    @Override
    public int deleteUserRole(
        Long userId,
        Long roleId) {
        return bbsMidUserRoleMapper.deleteUserRole(userId,
            roleId);
    }

}
