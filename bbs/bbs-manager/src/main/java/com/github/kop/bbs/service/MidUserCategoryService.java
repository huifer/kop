package com.github.kop.bbs.service;

import com.github.kop.bbs.module.req.midUserCategory.CreateMidUserCategoryReq;

/**
 * <p>
 * 版主与分类的中间表 服务类
 * </p>
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
public interface MidUserCategoryService {

    /**
     * 添加版主
     * @param req
     * @return
     */
    Boolean create(CreateMidUserCategoryReq req);

    /**
     * 移除版主
     * @param id
     * @param userId
     * @return
     */
    Boolean delete(Long id,Long userId);
}
