package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.category.UserCategoryApplyService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "消费者-申请版块接口")
@RestController
@RequestMapping("/customer/category")
public class CustomerCategoryApi {

  @Resource
  private UserCategoryApplyService userCategoryApplyService;

  @PostMapping("/apply/manager")
  @ApiOperation(value = "申请版主")
  public RespVO<Boolean> applyCategory(@RequestBody Long categoryId) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(userCategoryApplyService.applyCategory(categoryId, userId));
  }
}
