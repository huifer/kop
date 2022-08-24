package com.github.kop.bbs.api.manager.category;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.category.CategoryListRes;
import com.github.kop.bbs.service.category.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @auth ahxiaoqi
 * @desc 版块控制器
 * @time 2022/8/11 21:36
 */
@Api(tags = "管理端-版块接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

  @Resource private CategoryService bbsCategoryService;

  @ApiOperation(value = "添加板块")
  @PostMapping("/create")
  public RespVO<Boolean> create(@RequestBody CreateCategoryReq req) {
    return RespVO.success(bbsCategoryService.create(req));
  }

  @ApiOperation(value = "修改版块")
  @PutMapping("/{id}")
  public RespVO<Boolean> updateCategory(
      @PathVariable(value = "id") Long id, @RequestBody UpdateCategoryReq req) {
    req.setCategoryId(id);
    return RespVO.success(bbsCategoryService.updateCategory(req));
  }

  @ApiOperation(value = "版块列表")
  @GetMapping("/list/{page}/{size}")
  public RespVO<IPage<CategoryListRes>> page(
      @PathVariable(value = "page") Long page,
      @PathVariable(value = "size") Long size,
      @RequestBody QueryCategoryReq req) {
    return RespVO.success(bbsCategoryService.page(page, size, req));
  }
}
