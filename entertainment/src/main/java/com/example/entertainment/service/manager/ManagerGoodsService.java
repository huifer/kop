package com.example.entertainment.service.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.Goods;
import com.example.entertainment.module.manager.resp.goods.GoodsQueryResp;

public interface ManagerGoodsService {

  boolean create(Goods goods);

  boolean update(Goods goods);

  boolean delete(int id);

  IPage<GoodsQueryResp> page(int page, int size, Goods goods);
}
