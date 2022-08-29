package com.example.entertainment.ctr.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.Goods;
import com.example.entertainment.module.manager.resp.goods.GoodsCategoryQueryResp;
import com.example.entertainment.module.manager.resp.goods.GoodsQueryResp;
import com.example.entertainment.service.manager.ManagerGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Boolean> create(
      @RequestBody Goods goods
  ) {
    return ResponseEntity.ok(managerGoodsService.create(goods));
  }

  @ApiOperation("修改")
  @PostMapping("/update")
  public ResponseEntity<Boolean> update(
      @RequestBody Goods goods
  ) {
    return ResponseEntity.ok(managerGoodsService.update(goods));
  }

  @ApiOperation("删除")
  @PostMapping("/delete/{id}")
  public ResponseEntity<Boolean> update(
      @PathVariable("id") int id
  ) {
    return ResponseEntity.ok(managerGoodsService.delete(id));
  }

  @ApiOperation("分页")
  @PostMapping("/page/{page}/{size}")
  public ResponseEntity<IPage<GoodsQueryResp>> page(
      @PathVariable("page") int page,
      @PathVariable("size") int size,
      Goods goods
  ) {
    return ResponseEntity.ok(this.managerGoodsService.page(page, size, goods));
  }
}
