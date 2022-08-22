package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Appeal;
import com.github.kop.bbs.repo.AppealRepository;
import com.github.kop.bbs.repo.mapper.AppealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppealRepositoryImpl implements AppealRepository {

  @Autowired
  private AppealMapper appealMapper;

  @Override
  public int create(Appeal appeal) {
    return appealMapper.insert(appeal);
  }

  @Override
  public IPage<Appeal> page(Long page, Long size) {
    QueryWrapper<Appeal> queryWrapper = new QueryWrapper<>();
    return appealMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}
