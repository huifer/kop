package com.github.kop.bbs.api.customer;


import com.github.kop.bbs.module.res.RespVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/category")
public class CustomerCategoryApi {
  /**
   * 使用者申请板块
   * @return
   */
  @ApiOperation(value = "申请板块")
  @PostMapping("/apply")
  public RespVO<Boolean> apply(){
    return null;
  }
}
