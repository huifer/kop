package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.BbsCategory;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import org.springframework.stereotype.Repository;


public interface CategoryRepository {

  long  insert(BbsCategory insertEntity);

  int  updateById(BbsCategory updateEntity);

  IPage<BbsCategory> page(Long page, Long size, QueryCategoryReq req);
}
