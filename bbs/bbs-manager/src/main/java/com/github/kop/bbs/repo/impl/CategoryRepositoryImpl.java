package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.BbsCategory;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.repo.CategoryRepository;
import com.github.kop.bbs.repo.mapper.BbsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryRepositoryImpl implements CategoryRepository {

  @Autowired
  private BbsCategoryMapper bbsCategoryMapper;

  @Override
  public long insert(BbsCategory insertEntity) {
    int insert = bbsCategoryMapper.insert(insertEntity);
    if (insert > 0) {
      return insertEntity.getCategoryId();
    }
    return -1;
  }

  @Override
  public int updateById(BbsCategory updateEntity) {
    return this.bbsCategoryMapper.updateById(updateEntity);
  }

  @Override
  public IPage<BbsCategory> page(Long page, Long size, QueryCategoryReq req) {
    return this.bbsCategoryMapper.listWithPage(new Page<>(page, size), req);
  }
}
