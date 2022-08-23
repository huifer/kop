package com.github.kop.bbs.api.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.FeedBackReq;
import com.github.kop.bbs.module.res.FeedBackResp;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.feedback.FeedbackRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "消费者-反馈接口")
@RestController
@RequestMapping("/customer/feed_back")
public class CustomerFeedBackController {

  @Autowired
  private FeedbackRecordService feedbackRecordService;

  @ApiOperation("创建反馈")
  @PostMapping("/")
  public RespVO<Boolean> create(
      @RequestBody FeedBackReq req
  ) {

    return RespVO.success(feedbackRecordService.create(req));
  }

  @ApiOperation("反馈分页")
  @GetMapping("/page/{page}/{size}")
  public RespVO<IPage<FeedBackResp>> page(
      @PathVariable("page") Long page,
      @PathVariable("size") Long size) {
    return RespVO.success(feedbackRecordService.page(page, size));
  }
}
