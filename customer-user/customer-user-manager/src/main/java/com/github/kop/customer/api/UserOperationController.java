package com.github.kop.customer.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.req.BlackListReq;
import com.github.kop.customer.module.req.WhiteListReq;
import com.github.kop.customer.module.res.RespVO;
import com.github.kop.customer.module.res.UserInfoRes;
import com.github.kop.customer.service.UserBlackService;
import com.github.kop.customer.service.UserWhiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/operation")
public class UserOperationController {

    @Autowired
    private UserBlackService userBlackService;
    @Autowired
    private UserWhiteService userWhiteService;

    @PostMapping("/black")
    public RespVO<Boolean> blackAdd(
            @RequestBody BlackListReq blackListReq
    ) {
        boolean add = userBlackService.add(blackListReq.getUserId(), blackListReq.getOpUserId());
        return RespVO.success(add);
    }

    @PostMapping("/black/remove")
    public RespVO<Boolean> blackRemove(
            @RequestBody BlackListReq blackListReq
    ) {
        boolean add = userBlackService.remove(blackListReq.getUserId(), blackListReq.getOpUserId());
        return RespVO.success(add);
    }

    @GetMapping("/black/list/{cur}/{size}/{user_id}")
    public RespVO<IPage<UserInfoRes>> blackList(
            @PathVariable(value = "cur") long cur,
            @PathVariable(value = "size") long size,
            @PathVariable(value = "user_id") long userId
    ){
        return RespVO.success(this.userBlackService.blackList(userId,cur, size));
    }


    @PostMapping("/white")
    public RespVO<Boolean> whiteAdd(
            @RequestBody WhiteListReq whiteListReq
    ) {
        boolean add = userWhiteService.add(whiteListReq.getUserId(), whiteListReq.getOpUserId());
        return RespVO.success(add);
    }

    @PostMapping("/white/remove")
    public RespVO<Boolean> whiteRemove(
            @RequestBody WhiteListReq whiteListReq
    ) {
        boolean add = userWhiteService.remove(whiteListReq.getUserId(), whiteListReq.getOpUserId());
        return RespVO.success(add);
    }

}
