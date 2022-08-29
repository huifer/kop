package com.example.entertainment.service.common.impl;

import com.example.entertainment.repo.GoodsRepository;
import com.example.entertainment.service.common.GoodsService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {

  @Autowired
  private GoodsRepository goodsRepository;

  @Override
  public LocalDateTime minStartTimeByCategory(int category) {
    return goodsRepository.minStartTimeByCategory(category);
  }

}
