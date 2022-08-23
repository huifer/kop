package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.FeedbackRecord;
import com.github.kop.bbs.repo.FeedbackRecordRepository;
import com.github.kop.bbs.repo.mapper.FeedbackRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackRecordRepositoryImpl implements FeedbackRecordRepository {

  @Autowired
  private FeedbackRecordMapper feedbackRecordMapper;

  @Override
  public IPage<FeedbackRecord> page(Long page, Long size) {
    QueryWrapper<FeedbackRecord> queryWrapper = new QueryWrapper<>();
    return feedbackRecordMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public int create(FeedbackRecord feedbackRecord) {
    return feedbackRecordMapper.insert(feedbackRecord);
  }

}
