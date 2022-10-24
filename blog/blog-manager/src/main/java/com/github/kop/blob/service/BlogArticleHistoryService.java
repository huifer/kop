package com.github.kop.blob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogArticleHistory;
import java.util.List;

public interface BlogArticleHistoryService extends IService<BlogArticleHistory> {

  int updateBatchSelective(List<BlogArticleHistory> list);

  int batchInsert(List<BlogArticleHistory> list);
}
