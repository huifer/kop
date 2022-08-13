package com.github.kop.bbs.service;

import com.github.kop.bbs.module.entity.MidUserRole;

/**
 * <p>
 * 用户角色中间表 服务类
 * </p>
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
public interface MidUserRoleService {

    /**
     * 添加角色
     * @param build
     */
    void addUserRole(MidUserRole build);

    /**
     * 验证角色
     * @param midUserRole
     * @return
     */
    boolean existsUserRole(MidUserRole midUserRole);

    /**
     * 删除角色
     * @param build
     */
    void deleteUserRole(MidUserRole build);
}
