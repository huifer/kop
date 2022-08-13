package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.req.midUserCategory.CreateMidUserCategoryReq;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/13 14:42
 */
public interface MidUserRoleRepository {

    /**
     * 添加角色
     * @param build
     */
    int insert(MidUserRole midUserRole);

    /**
     * 验证角色
     * @param midUserRole
     * @return
     */
    boolean existsUserRole(MidUserRole midUserRole);

    int deleteUserRole(MidUserRole midUserRole);
}
