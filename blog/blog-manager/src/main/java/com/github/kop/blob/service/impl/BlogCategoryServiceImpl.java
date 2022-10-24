package com.github.kop.blob.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.module.entity.BlogCategory;
import com.github.kop.blob.repo.mapper.BlogCategoryMapper;
import com.github.kop.blob.service.BlogCategoryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogCategoryServiceImpl extends ServiceImpl<BlogCategoryMapper, BlogCategory>
    implements BlogCategoryService {

  @Override
  public int updateBatchSelective(List<BlogCategory> list) {
    return baseMapper.updateBatchSelective(list);
  }

  @Override
  public int batchInsert(List<BlogCategory> list) {
    return baseMapper.batchInsert(list);
  }
}
