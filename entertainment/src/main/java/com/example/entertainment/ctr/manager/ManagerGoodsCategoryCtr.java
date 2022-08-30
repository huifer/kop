package com.example.entertainment.ctr.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.RespVO;
import com.example.entertainment.module.entity.GoodsCategory;
import com.example.entertainment.module.manager.req.goods.GoodsCategoryCreateReq;
import com.example.entertainment.module.manager.resp.goods.GoodsCategoryQueryResp;
import com.example.entertainment.service.manager.ManagerGoodsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("管理端-商品系列接口")
@RestController
@RequestMapping("/manager/goods/category")
public class ManagerGoodsCategoryCtr {

  @Autowired
  private ManagerGoodsCategoryService managerGoodsCategoryService;

  @ApiOperation("创建")
  @PostMapping("/create")
  public RespVO<Boolean> create(
      @RequestBody GoodsCategoryCreateReq req
  ) {
    return RespVO.success(this.managerGoodsCategoryService.create(req));

  }

  @ApiOperation("修改")
  @PostMapping("/update")
  public RespVO<Boolean> update(
      @RequestBody GoodsCategory goodsCategory
  ) {
    return RespVO.success(this.managerGoodsCategoryService.update(goodsCategory));
  }

  @ApiOperation("删除")
  @PostMapping("/delete/{id}")
  public RespVO<Boolean> delete(
      @PathVariable("id") int id
  ) {
    return RespVO.success(this.managerGoodsCategoryService.delete(id));

  }


  @ApiOperation("分页")
  @GetMapping("/page/{page}/{size}")
  public RespVO<IPage<GoodsCategoryQueryResp>> page(
      @PathVariable("page") int page,
      @PathVariable("size") int size,
      String name
  ) {
    return RespVO.success(this.managerGoodsCategoryService.page(page, size, name));
  }

  @ApiOperation("列表")
  @GetMapping("/list")
  public RespVO<List<GoodsCategoryQueryResp>> list() {
    return RespVO.success(this.managerGoodsCategoryService.list());
  }
}
