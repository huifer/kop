package com.example.entertainment.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entertainment.module.entity.Goods;
import com.example.entertainment.repo.GoodsRepository;
import com.example.entertainment.repo.mapper.GoodsMapper;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GoodsRepositoryImpl implements GoodsRepository {

  @Autowired
  private GoodsMapper goodsMapper;

  @Override
  public LocalDateTime minStartTimeByCategory(int category) {
    return goodsMapper.minStartTimeByCategory(category);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(Goods goods) {
    return this.goodsMapper.insert(goods);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int update(Goods goods) {
    return this.goodsMapper.updateById(goods);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int delete(int id) {
    return this.goodsMapper.deleteById(id);
  }

  @Override
  public IPage<Goods> page(int page, int size, Goods goods) {
    QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
    return this.goodsMapper.selectPage(new Page<>(page, size), queryWrapper);
  }
}
