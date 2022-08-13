package com.github.kop.bbs.service.impl;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.service.MidUserRoleService;
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
     * @param midUserRole
     * @return
     */
    @Override
    public boolean existsUserRole(MidUserRole midUserRole) {
        return midUserRoleRepository.existsUserRole(midUserRole);
    }

    /**
     * 删除角色
     *
     * @param build
     */
    @Override
    public void deleteUserRole(MidUserRole build) {
        midUserRoleRepository.deleteUserRole(build);
    }
}
