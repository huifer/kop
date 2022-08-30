package com.example.entertainment.service.manager.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.GoodsCategory;
import com.example.entertainment.module.manager.req.goods.GoodsCategoryCreateReq;
import com.example.entertainment.module.manager.resp.goods.GoodsCategoryQueryResp;
import com.example.entertainment.repo.GoodsCategoryRepository;
import com.example.entertainment.service.manager.ManagerGoodsCategoryService;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerGoodsCategoryServiceImpl implements ManagerGoodsCategoryService {

  @Autowired
  private GoodsCategoryRepository goodsCategoryRepository;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(GoodsCategoryCreateReq req) {
    GoodsCategory goodsCategory = new GoodsCategory();
    goodsCategory.setName(req.getName());
    goodsCategory.setImage(req.getImage());
    goodsCategory.setOrder(req.getOrder());
    goodsCategory.setIsShow(req.getIsShow() ? 1 : 0);

    return goodsCategoryRepository.create(goodsCategory) > 0;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean update(GoodsCategory goodsCategory) {
    return this.goodsCategoryRepository.updateById(goodsCategory) > 0;
  }

  @Override
  public boolean delete(int id) {
    return this.goodsCategoryRepository.deleteById(id) > 0;
  }

  @Override
  public IPage<GoodsCategoryQueryResp> page(int page, int size, String name) {
    IPage<GoodsCategory> page1 = this.goodsCategoryRepository.page(page, size, name);
    return page1.convert(new Function<GoodsCategory, GoodsCategoryQueryResp>() {
      @Override
      public GoodsCategoryQueryResp apply(GoodsCategory goodsCategory) {
        GoodsCategoryQueryResp goodsCategoryQueryResp = new GoodsCategoryQueryResp();
        BeanUtils.copyProperties(goodsCategory, goodsCategoryQueryResp);
        return goodsCategoryQueryResp;
      }
    });
  }

  @Override
  public List<GoodsCategoryQueryResp> list() {
    List<GoodsCategory> list = this.goodsCategoryRepository.list();
    List<GoodsCategoryQueryResp> res = new ArrayList<>();
    for (GoodsCategory goodsCategory : list) {
      GoodsCategoryQueryResp goodsCategoryQueryResp = new GoodsCategoryQueryResp();
      BeanUtils.copyProperties(goodsCategory, goodsCategoryQueryResp);
      res.add(goodsCategoryQueryResp);
    }
    return res;
  }
}
