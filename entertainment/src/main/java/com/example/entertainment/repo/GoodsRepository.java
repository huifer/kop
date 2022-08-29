package com.example.entertainment.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.Goods;
import java.time.LocalDateTime;

public interface GoodsRepository {

  /**
   * 查询某个系列下最早的开始售卖时间
   */
  LocalDateTime minStartTimeByCategory(int category);

  int  create(Goods goods);

  int  update(Goods goods);

  int  delete(int id);

  IPage<Goods> page(int page, int size, Goods goods);
}
