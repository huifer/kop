package com.github.kop.rbac.api;


import com.github.kop.rbac.module.req.login.LoginReq;
import com.github.kop.rbac.module.res.RespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "登录接口")
@RestController
@RequestMapping("/login")
public class LoginController {


    @ApiOperation(value = "登录接口")
    @PostMapping("/")
    public RespVO<?> login(@RequestBody LoginReq loginReq) {

        return RespVO.success();
    }
}
