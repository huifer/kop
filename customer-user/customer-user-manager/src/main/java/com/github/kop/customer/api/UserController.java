package com.github.kop.customer.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.req.RegisterUserReq;
import com.github.kop.customer.module.res.RespVO;
import com.github.kop.customer.module.res.UserInfoRes;
import com.github.kop.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RespVO<Boolean> register(
            @RequestBody RegisterUserReq userReq
    ) {
        boolean register = userService.register(userReq);
        return RespVO.success(register);
    }

    @GetMapping("/page/{cur}/{size}/{cur_user_id}")
    public RespVO<IPage<UserInfoRes>> page(
            @PathVariable(value = "cur") long cur,
            @PathVariable(value = "size") long size,
            @PathVariable(value = "cur_user_id") long curUserId

    ) {
        return RespVO.success(this.userService.page(cur, size, curUserId));
    }
}
