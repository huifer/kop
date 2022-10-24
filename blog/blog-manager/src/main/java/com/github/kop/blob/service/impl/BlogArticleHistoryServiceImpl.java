package com.github.kop.blob.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.module.entity.BlogArticleHistory;
import com.github.kop.blob.repo.mapper.BlogArticleHistoryMapper;
import com.github.kop.blob.service.BlogArticleHistoryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogArticleHistoryServiceImpl
    extends ServiceImpl<BlogArticleHistoryMapper, BlogArticleHistory>
    implements BlogArticleHistoryService {

  @Override
  public int updateBatchSelective(List<BlogArticleHistory> list) {
    return baseMapper.updateBatchSelective(list);
  }

  @Override
  public int batchInsert(List<BlogArticleHistory> list) {
    return baseMapper.batchInsert(list);
  }
}
