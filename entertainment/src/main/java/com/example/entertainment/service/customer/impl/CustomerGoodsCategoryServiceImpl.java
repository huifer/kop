package com.example.entertainment.service.customer.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.GoodsCategory;
import com.example.entertainment.module.manager.resp.goods.GoodsCategoryQueryResp;
import com.example.entertainment.repo.GoodsCategoryRepository;
import com.example.entertainment.service.customer.CustomerGoodsCategoryService;
import java.util.function.Function;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerGoodsCategoryServiceImpl implements CustomerGoodsCategoryService {

  @Autowired
  private GoodsCategoryRepository goodsCategoryRepository;

  @Override
  public IPage<GoodsCategoryQueryResp> page(int page, int size) {
    IPage<GoodsCategory> iPage = this.goodsCategoryRepository.page(page, size, null);
    return iPage.convert(new Function<GoodsCategory, GoodsCategoryQueryResp>() {
      @Override
      public GoodsCategoryQueryResp apply(GoodsCategory goodsCategory) {
        GoodsCategoryQueryResp goodsCategoryQueryResp = new GoodsCategoryQueryResp();
        BeanUtils.copyProperties(goodsCategory, goodsCategoryQueryResp);
        return goodsCategoryQueryResp;
      }
    });
  }
}
