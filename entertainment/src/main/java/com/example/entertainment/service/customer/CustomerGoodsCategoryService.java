package com.example.entertainment.service.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.manager.resp.goods.GoodsCategoryQueryResp;

public interface CustomerGoodsCategoryService {

  IPage<GoodsCategoryQueryResp> page(int page, int size);
}
