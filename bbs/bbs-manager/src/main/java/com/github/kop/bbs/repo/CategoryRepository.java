package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Category;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;

public interface CategoryRepository {

  long insert(Category insertEntity);

  int updateById(Category updateEntity);

  IPage<Category> page(Long page, Long size, QueryCategoryReq req);

  /**
   * 根据分类名字校验名称是否存在
   *
   * @param categoryName
   * @return
   */
  boolean existsCategoryName(String categoryName);
}
