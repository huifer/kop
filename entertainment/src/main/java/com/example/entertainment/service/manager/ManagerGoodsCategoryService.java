package com.example.entertainment.service.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.GoodsCategory;
import com.example.entertainment.module.manager.req.goods.GoodsCategoryCreateReq;
import com.example.entertainment.module.manager.resp.goods.GoodsCategoryQueryResp;
import java.util.List;

public interface ManagerGoodsCategoryService {

  boolean create(GoodsCategoryCreateReq req);

  boolean update(GoodsCategory goodsCategory);

  boolean delete(int id);

  IPage<GoodsCategoryQueryResp> page(int page, int size, String name);

  List<GoodsCategoryQueryResp> list();
}
