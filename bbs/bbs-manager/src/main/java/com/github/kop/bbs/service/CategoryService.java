package com.github.kop.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.res.category.CategoryListRes;

public interface CategoryService {



    /**
     * 添加板块
     * @param req
     * @return
     */
    Boolean create(CreateCategoryReq req);

    /**
     * 修改版块
     * @param req
     * @return
     */
    Boolean updateCategory(UpdateCategoryReq req);

    /**
     * 分页查询列表
     * @param page
     * @param size
     * @param req
     * @return
     */
    IPage<CategoryListRes> list(Long page, Long size, QueryCategoryReq req);
}


