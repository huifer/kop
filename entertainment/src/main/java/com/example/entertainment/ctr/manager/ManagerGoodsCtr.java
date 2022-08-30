package com.example.entertainment.ctr.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.RespVO;
import com.example.entertainment.module.entity.Goods;
import com.example.entertainment.module.manager.resp.goods.GoodsQueryResp;
import com.example.entertainment.service.manager.ManagerGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("管理端-商品接口")
@RestController
@RequestMapping("/manager/goods")
public class ManagerGoodsCtr {

  @Autowired
  private ManagerGoodsService managerGoodsService;

  @ApiOperation("创建")
  @PostMapping("/create")
  public RespVO<Boolean> create(
      @RequestBody Goods goods
  ) {
    return RespVO.success(managerGoodsService.create(goods));
  }

  @ApiOperation("修改")
  @PostMapping("/update")
  public RespVO<Boolean> update(
      @RequestBody Goods goods
  ) {
    return RespVO.success(managerGoodsService.update(goods));
  }

  @ApiOperation("删除")
  @PostMapping("/delete/{id}")
  public RespVO<Boolean> update(
      @PathVariable("id") int id
  ) {
    return RespVO.success(managerGoodsService.delete(id));
  }

  @ApiOperation("分页")
  @PostMapping("/page/{page}/{size}")
  public RespVO<IPage<GoodsQueryResp>> page(
      @PathVariable("page") int page,
      @PathVariable("size") int size,
      Goods goods
  ) {
    return RespVO.success(this.managerGoodsService.page(page, size, goods));
  }
}
