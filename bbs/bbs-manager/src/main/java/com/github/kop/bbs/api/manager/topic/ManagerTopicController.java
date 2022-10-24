package com.github.kop.bbs.api.manager.topic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.aop.role.RoleApi;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.req.topic.TopicAuditReq;
import com.github.kop.bbs.module.req.topic.TopicQueryReq;
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

@Api(tags = "管理的-论坛话题")
@RestController
@RequestMapping("/manager/topic")
public class ManagerTopicController {

  @Autowired private TopicService topicService;

  @RoleApi(roles = {RoleEnum.AUDIT})
  @ApiOperation("审核")
  @PostMapping("/audit")
  public RespVO<Boolean> audit(@RequestBody TopicAuditReq req) {
    return RespVO.success(topicService.audit(UserInfoThread.getUserId(), req));
  }

  @ApiOperation("分页")
  @GetMapping("/page/{page}/{size}")
  public RespVO<IPage<TopicQueryResp>> page(
      @PathVariable("page") Long page, @PathVariable("size") Long size, TopicQueryReq req) {

    return RespVO.success(topicService.page(page, size, req));
  }
}
