package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.req.topic.TopicCreateReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.topic.TopicService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("话题")
@RestController
@RequestMapping("/customer/topic")
public class CustomerTopicController {

  @Autowired
  private TopicService topicService;


  @ApiOperation("创建话题")
  @PostMapping("/create")
  public RespVO<Boolean> create(
      @RequestBody TopicCreateReq req
  ) {
    return RespVO.success(topicService.create(req, UserInfoThread.getUserId()));

  }
}
