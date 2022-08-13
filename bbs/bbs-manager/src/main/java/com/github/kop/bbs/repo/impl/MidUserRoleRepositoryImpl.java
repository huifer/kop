package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.repo.mapper.MidUserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 14:43
 */
@Service
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
        validateUserRole(midUserRole);
        return bbsMidUserRoleMapper.insert(midUserRole);
    }

    private void validateUserRole(MidUserRole midUserRole){
        if (existsUserRole(midUserRole)) {
            throw new NoceException("当前用户角色已存在");
        }
    }

    /**
     * 验证角色
     * @param midUserRole
     * @return
     */
    public boolean existsUserRole(MidUserRole midUserRole){
        QueryWrapper<MidUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(MidUserRole::getRoleCode, midUserRole.getRoleCode())
                .eq(MidUserRole::getUserId, midUserRole.getUserId())
                .eq(MidUserRole::getDeleted, DeletedEnum.FALSE.getCode());
       return bbsMidUserRoleMapper.exists(queryWrapper);
    }

    @Override
    public int deleteUserRole(MidUserRole midUserRole) {
       return bbsMidUserRoleMapper.deleteUserRole(midUserRole);
    }

}
