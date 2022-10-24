package com.github.kop.blob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogSpecialColumn;
import java.util.List;

public interface BlogSpecialColumnService extends IService<BlogSpecialColumn> {

  int updateBatchSelective(List<BlogSpecialColumn> list);

  int batchInsert(List<BlogSpecialColumn> list);
}
