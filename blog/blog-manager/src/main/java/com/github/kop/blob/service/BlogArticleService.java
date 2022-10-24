package com.github.kop.blob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogArticle;
import java.util.List;

public interface BlogArticleService extends IService<BlogArticle> {

  int updateBatchSelective(List<BlogArticle> list);

  int batchInsert(List<BlogArticle> list);
}
