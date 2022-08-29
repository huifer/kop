package com.example.entertainment.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.GoodsCategory;
import java.util.List;

public interface GoodsCategoryRepository {

  IPage<GoodsCategory> page(int page, int size, String name);

  int  create(GoodsCategory goodsCategory);

  int updateById(GoodsCategory goodsCategory);

  int  deleteById(int id);

  List<GoodsCategory> list();


}
