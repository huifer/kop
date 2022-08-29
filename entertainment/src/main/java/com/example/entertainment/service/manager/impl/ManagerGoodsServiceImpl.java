package com.example.entertainment.service.manager.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.Goods;
import com.example.entertainment.module.manager.resp.goods.GoodsQueryResp;
import com.example.entertainment.repo.GoodsRepository;
import com.example.entertainment.service.manager.ManagerGoodsService;
import java.util.function.Function;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class ManagerGoodsServiceImpl implements ManagerGoodsService {

  @Autowired
  private GoodsRepository goodsRepository;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(Goods goods) {
    return goodsRepository.create(goods) > 0;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean update(Goods goods) {
    return goodsRepository.update(goods) > 0;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean delete(int id) {
    return goodsRepository.delete(id) > 0;
  }

  @Override
  public IPage<GoodsQueryResp> page(int page, int size, Goods goods) {
    IPage<Goods> goodsIPage = this.goodsRepository.page(page, size, goods);
    return goodsIPage.convert(new Function<Goods, GoodsQueryResp>() {
      @Override
      public GoodsQueryResp apply(Goods goods) {
        GoodsQueryResp goodsQueryResp = new GoodsQueryResp();
        BeanUtils.copyProperties(goods, goodsQueryResp);
        return goodsQueryResp;
      }
    });
  }
}
