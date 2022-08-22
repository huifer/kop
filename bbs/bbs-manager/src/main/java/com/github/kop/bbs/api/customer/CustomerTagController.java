package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.tag.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("标签")
@RestController
@RequestMapping("/customer/tag")
public class CustomerTagController {


  @Autowired
  private TagService tagService;

  @ApiOperation("创建标签")
  @PostMapping("/create")
  public RespVO<Boolean> create(
  ) {
    return null;

  }
}
