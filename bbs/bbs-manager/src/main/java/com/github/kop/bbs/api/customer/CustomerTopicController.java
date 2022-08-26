package com.github.kop.bbs.api.customer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.topic.TopicCreateReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.topic.TopicQueryResp;
import com.github.kop.bbs.service.topic.TopicService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @ApiOperation("话题列表")
  @GetMapping("/page/{page}/{size}")
  public RespVO<IPage<TopicQueryResp>> page(
      @PathVariable("page") Long page,
      @PathVariable("size") Long size
  ) {
    return RespVO.success(topicService.pagePass(page, size));
  }

  // TODO: 2022/8/26 话题内容分页 ，热度和创建时间两种排序
}
