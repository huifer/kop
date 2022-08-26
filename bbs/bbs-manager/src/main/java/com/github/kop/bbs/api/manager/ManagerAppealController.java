package com.github.kop.bbs.api.manager;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理的-论坛申诉")
@RestController
@RequestMapping("/manager/appeal")
public class ManagerAppealController {

  // TODO: 2022/8/26 对申诉进行反馈意见回复

}
