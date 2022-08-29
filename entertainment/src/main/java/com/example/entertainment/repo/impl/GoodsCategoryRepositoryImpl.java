package com.example.entertainment.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entertainment.module.entity.GoodsCategory;
import com.example.entertainment.repo.GoodsCategoryRepository;
import com.example.entertainment.repo.GoodsRepository;
import com.example.entertainment.repo.mapper.GoodsCategoryMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = {Exception.class})

public class GoodsCategoryRepositoryImpl implements GoodsCategoryRepository {

  @Autowired
  private GoodsCategoryMapper goodsCategoryMapper;
  @Autowired
  private GoodsRepository goodsRepository;

  @Override
  public IPage<GoodsCategory> page(int page, int size, String name) {
    QueryWrapper<GoodsCategory> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .like(StringUtils.isNotBlank(name), GoodsCategory::getName, name)
    ;
    return goodsCategoryMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int create(GoodsCategory goodsCategory) {
    return this.goodsCategoryMapper.insert(goodsCategory);
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int updateById(GoodsCategory goodsCategory) {
    //     // 当前时间 > 系列下某个商品的开始售卖时间不允许修改
    checkMinTime(goodsCategory.getId());
    return goodsCategoryMapper.updateById(goodsCategory);
  }

  private void checkMinTime(int categoryId) {
    LocalDateTime startTime = goodsRepository.minStartTimeByCategory(categoryId);
    if (LocalDateTime.now().isAfter(startTime)) {
      throw new RuntimeException("已经有商品在售卖无法修改");
    }
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public int deleteById(int id) {
    //     // 当前时间 > 系列下某个商品的开始售卖时间不允许修改
    checkMinTime(id);
    return this.goodsCategoryMapper.deleteById(id);
  }

  @Override
  public List<GoodsCategory> list() {
    return this.goodsCategoryMapper.selectList(new QueryWrapper<>());
  }

}
