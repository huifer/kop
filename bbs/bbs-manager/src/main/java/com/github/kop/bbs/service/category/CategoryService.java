package com.github.kop.bbs.service.category;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.res.category.CategoryListRes;
import java.util.List;

/** 板块服务 */
public interface CategoryService {

  /**
   * 添加板块
   *
   * @param req
   * @return
   */
  Boolean create(CreateCategoryReq req);

  /**
   * 修改版块
   *
   * @param req
   * @return
   */
  Boolean updateCategory(UpdateCategoryReq req);

  /**
   * 分页查询列表
   *
   * @param page
   * @param size
   * @param req
   * @return
   */
  IPage<CategoryListRes> page(Long page, Long size, QueryCategoryReq req);

  /**
   * 顶层板块列表
   */
  List<CategoryListRes> topList();


  /**
   * 某个板块下的板块列表
   */
  List<CategoryListRes> subList(Long categoryId);
}
