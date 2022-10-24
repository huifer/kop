package com.github.kop.blob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogCategory;
import java.util.List;

public interface BlogCategoryService extends IService<BlogCategory> {

  int updateBatchSelective(List<BlogCategory> list);

  int batchInsert(List<BlogCategory> list);
}
