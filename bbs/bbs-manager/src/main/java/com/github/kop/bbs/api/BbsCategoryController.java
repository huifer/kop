package com.github.kop.bbs.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.category.CreateCategoryReq;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import com.github.kop.bbs.module.req.category.UpdateCategoryReq;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.category.CategoryListRes;
import com.github.kop.bbs.service.BbsCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc 版块控制器
 * @time 2022/8/11 21:36
 */
@Api(value = "版块接口")
@RestController
@RequestMapping("/category")
public class BbsCategoryController {

    @Resource
    private BbsCategoryService bbsCategoryService;


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
    public RespVO<IPage<CategoryListRes>> list(
            @PathVariable(value = "page") Long page,
            @PathVariable(value = "size") Long size,
            @RequestBody QueryCategoryReq req) {
        return RespVO.success(bbsCategoryService.list(page,size,req));
    }

}
