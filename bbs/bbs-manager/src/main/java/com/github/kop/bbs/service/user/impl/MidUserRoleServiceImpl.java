package com.github.kop.bbs.service.user.impl;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.service.user.MidUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户角色中间表 服务实现类
 * </p>
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Service
public class MidUserRoleServiceImpl implements MidUserRoleService {



    @Resource
    private MidUserRoleRepository midUserRoleRepository;

    /**
     * 添加角色
     *
     * @param build
     */
    @Override
    public void addUserRole(MidUserRole build) {
        midUserRoleRepository.insert(build);
    }

    /**
     * 验证角色
     *
     */
    @Override
    public boolean existsUserRole(Long userId, String roleCode) {
        return midUserRoleRepository.existsUserRole(userId, roleCode);
    }

    /**
     * 删除角色
     *
     * @param build
     */
    @Override
    public boolean deleteUserRole(
        Long userId,
        Long roleId) {
        return midUserRoleRepository.deleteUserRole(userId, roleId) > 0;
    }
}
