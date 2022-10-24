package com.github.kop.blob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogCollection;
import java.util.List;

public interface BlogCollectionService extends IService<BlogCollection> {

  int updateBatchSelective(List<BlogCollection> list);

  int batchInsert(List<BlogCollection> list);
}
