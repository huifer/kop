package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.category.UserCategoryApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "使用申请版块接口")
@RestController
@RequestMapping("/customer/category")
public class CustomerCategoryApi {

  @Resource
  private UserCategoryApplyService userCategoryApplyService;

  @PostMapping("/apply/manager")
  @ApiOperation(value = "申请版主")
  public RespVO<Boolean> applyCategory(@RequestBody Long categoryId) {
    return RespVO.success(userCategoryApplyService.applyCategory(categoryId));
  }
}
