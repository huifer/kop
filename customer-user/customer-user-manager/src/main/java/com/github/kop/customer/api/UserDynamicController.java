package com.github.kop.customer.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.customer.module.req.DynamicAddReq;
import com.github.kop.customer.module.req.DynamicCommentReq;
import com.github.kop.customer.module.res.DynamicListRes;
import com.github.kop.customer.module.res.RespVO;
import com.github.kop.customer.service.UserDynamicCommentService;
import com.github.kop.customer.service.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/dynamic")
public class UserDynamicController {
  @Autowired private UserDynamicService userDynamicService;
  @Autowired private UserDynamicCommentService userDynamicCommentService;

  @PostMapping("/push")
  public RespVO<Boolean> push(@RequestBody DynamicAddReq req) {
    return RespVO.success(userDynamicService.create(req.getUserId(), req.getMsg()));
  }

  @GetMapping("/page/{cur}/{size}/{user_id}")
  public RespVO<IPage<DynamicListRes>> page(
      @PathVariable(value = "cur") long cur,
      @PathVariable(value = "size") long size,
      @PathVariable(value = "user_id") long userId) {
    return RespVO.success(userDynamicService.page(cur, size, userId));
  }

  @PostMapping("/comment")
  public RespVO<Boolean> comment(@RequestBody DynamicCommentReq dynamicCommentReq) {
    boolean b =
        userDynamicCommentService.create(
            dynamicCommentReq.getUserId(),
            dynamicCommentReq.getMsg(),
            dynamicCommentReq.getDynamicId(),
            dynamicCommentReq.getPid());
    return RespVO.success(b);
  }
}
