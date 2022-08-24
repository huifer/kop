package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Category;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import java.util.List;

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

  /**
   * 查询顶层板块
   */
  List<Category> topList();

  /**
   * 查询板块id下的一层板块
   */
  List<Category> subList(Long categoryId);


  Category byId(Long id);
}
