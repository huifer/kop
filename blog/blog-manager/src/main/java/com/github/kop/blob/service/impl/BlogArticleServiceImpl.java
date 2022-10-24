package com.github.kop.blob.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.module.entity.BlogArticle;
import com.github.kop.blob.repo.mapper.BlogArticleMapper;
import com.github.kop.blob.service.BlogArticleService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle>
    implements BlogArticleService {

  @Override
  public int updateBatchSelective(List<BlogArticle> list) {
    return baseMapper.updateBatchSelective(list);
  }

  @Override
  public int batchInsert(List<BlogArticle> list) {
    return baseMapper.batchInsert(list);
  }
}
