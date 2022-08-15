package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Category;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.repo.CategoryRepository;
import com.github.kop.bbs.repo.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

  @Autowired private CategoryMapper bbsCategoryMapper;

  @Override
  public long insert(Category insertEntity) {
    // 插入前再次校验是否存在
    validateCategoryName(insertEntity.getCategoryName());
    int insert = bbsCategoryMapper.insert(insertEntity);
    if (insert > 0) {
      return insertEntity.getCategoryId();
    }
    return -1;
  }

  @Override
  public int updateById(Category updateEntity) {
    return this.bbsCategoryMapper.updateById(updateEntity);
  }

  private void validateCategoryName(String categoryName) {
    boolean exists = existsCategoryName(categoryName);
    if (exists) {
      throw new ValidateException("分类名称已经存在");
    }
  }

  @Override
  public IPage<Category> page(Long page, Long size, QueryCategoryReq req) {
    return this.bbsCategoryMapper.listWithPage(new Page<>(page, size), req);
  }
  /**
   * 根据分类名字校验名称是否存在
   *
   * @param categoryName
   * @return
   */
  @Override
  public boolean existsCategoryName(String categoryName) {
    QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().eq(Category::getCategoryName, categoryName);
    return this.bbsCategoryMapper.exists(queryWrapper);
  }
}
