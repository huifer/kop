package com.github.kop.bbs.api.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.appeal.CreateAppealReq;
import com.github.kop.bbs.module.req.appeal.ReplyAppealReq;
import com.github.kop.bbs.module.res.appeal.AppealReceiptResp;
import com.github.kop.bbs.module.res.appeal.AppealResp;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.appeal.AppealReceiptService;
import com.github.kop.bbs.service.appeal.AppealService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "消费者-论坛申诉")
@RestController
@RequestMapping("customer/appeal")
public class CustomerAppealController {

  @Autowired
  private AppealService appealService;

  @Resource
  private AppealReceiptService appealReceiptService;


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
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(this.appealService.page(page, size,userId));
  }

  @ApiOperation(value = "回复投诉")
  @PostMapping("/page/{appealId}/{appealReceiptId}")
  public RespVO<Boolean> replyAppeal(
          @PathVariable Long appealId,
          @PathVariable(required = false) Long appealReceiptId,
          @RequestBody ReplyAppealReq req) {
    return RespVO.success(appealReceiptService.customerReplyAppeal(appealId, appealReceiptId, req));
  }


  @ApiOperation(value = "申诉回执列表")
  @GetMapping("/receipt/list/{appealId}")
  public RespVO<List<AppealReceiptResp>> receiptList(
          @PathVariable Long appealId) {
    return RespVO.success(appealReceiptService.receiptList(appealId));
  }

}
