package com.github.kop.bbs.api.manager;

import com.github.kop.bbs.module.req.midUserCategory.CreateMidUserCategoryReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.MidUserCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 版主与分类的中间表 前端控制器
 * </p>
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Api(tags="版主接口")
@RestController
@RequestMapping("/mid_user_category")
public class MidUserCategoryController {

    @Resource
    private MidUserCategoryService midUserCategoryService;

    @ApiOperation(value = "添加版主")
    @PostMapping("/create")
    public RespVO<Boolean> create(@RequestBody CreateMidUserCategoryReq req) {
        return RespVO.success(midUserCategoryService.create(req));
    }

    @ApiOperation(value = "移除版主")
    @DeleteMapping("/{id}/{userId}")
    public RespVO<Boolean> delete(@PathVariable("id") Long id,@PathVariable("userId")Long userId) {
        return RespVO.success(midUserCategoryService.delete(id,userId));
    }


}
