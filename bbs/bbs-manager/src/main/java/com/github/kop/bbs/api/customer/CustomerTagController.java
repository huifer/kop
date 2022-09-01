package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.req.tag.TagAddReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.tag.TagService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("标签")
@RestController
@RequestMapping("/customer/tag")
public class CustomerTagController {


  @Autowired
  private TagService tagService;

  @ApiOperation("创建标签")
  @PostMapping("/create")
  public RespVO<Boolean> create(@RequestBody TagAddReq tagAddReq) {
    return RespVO.success(tagService.create(tagAddReq, UserInfoThread.getUserId()));

  }
}
