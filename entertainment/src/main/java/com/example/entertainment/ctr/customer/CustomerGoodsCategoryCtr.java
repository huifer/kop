package com.example.entertainment.ctr.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.RespVO;
import com.example.entertainment.module.manager.resp.goods.GoodsCategoryQueryResp;
import com.example.entertainment.service.customer.CustomerGoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("消费者端-商品系列接口")
@RestController
@RequestMapping("/customer/goods/category")
public class CustomerGoodsCategoryCtr {

  @Autowired
  private CustomerGoodsCategoryService customerGoodsCategoryService;

  @ApiOperation("分页")
  @PostMapping("/page/{page}/{size}")
  public RespVO<IPage<GoodsCategoryQueryResp>> page(
      @PathVariable("page") int page,
      @PathVariable("size") int size
  ) {
    return RespVO.success(this.customerGoodsCategoryService.page(page,size));
  }



}
