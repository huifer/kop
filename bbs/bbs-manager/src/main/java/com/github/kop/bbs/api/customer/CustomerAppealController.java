package com.github.kop.bbs.api.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.appeal.CreateAppealReq;
import com.github.kop.bbs.module.res.AppealResp;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.appeal.AppealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "消费者-论坛申诉")
@RestController
@RequestMapping("customer/appeal")
public class CustomerAppealController {

  @Autowired
  private AppealService appealService;

  @ApiOperation(value = "发起申诉")
  @PostMapping("/")
  public RespVO<Boolean> create(
      @RequestBody CreateAppealReq req
  ) {
    return RespVO.success(this.appealService.create(req));
  }

  @ApiOperation(value = "申诉分页")
  @PostMapping("/page/{page}/{size}")
  public RespVO<IPage<AppealResp>> page(
      @PathVariable("page") Long page,
      @PathVariable("size") Long size
  ){
    return RespVO.success(this.appealService.page(page, size));
  }




}
