package com.github.kop.blob.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.module.entity.BlogFocus;
import com.github.kop.blob.repo.mapper.BlogFocusMapper;
import com.github.kop.blob.service.BlogFocusService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BlogFocusServiceImpl extends ServiceImpl<BlogFocusMapper, BlogFocus>
    implements BlogFocusService {

  @Override
  public int updateBatchSelective(List<BlogFocus> list) {
    return baseMapper.updateBatchSelective(list);
  }

  @Override
  public int batchInsert(List<BlogFocus> list) {
    return baseMapper.batchInsert(list);
  }
}
