package com.github.kop.bbs.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.BbsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc 用户控制器
 * @time 2022/8/9 22:17
 */
@Api(value = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private BbsUserService bbsUserService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/create")
    public RespVO<Boolean> create(@RequestBody CreateUserReq req) {
        return RespVO.success(bbsUserService.create(req));
    }

    @ApiOperation(value = "修改用户")
    @PutMapping("/{id}")
    public RespVO<Boolean> updateUser(
            @PathVariable(value = "id") Long id, @RequestBody UpdateUserReq req) {
        req.setId(id);
        return RespVO.success(bbsUserService.updateUser(req));
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public RespVO<?> byId() {
        System.out.println(LocalDate.now());
        return RespVO.success();
    }



}
