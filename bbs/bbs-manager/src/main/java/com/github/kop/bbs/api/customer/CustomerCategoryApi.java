package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.category.MidUserCategoryVoteApplyService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

@Api(tags = "消费者-版块相关接口")
@RestController
@RequestMapping("/customer/category")
public class CustomerCategoryApi {

  @Resource
  private MidUserCategoryVoteApplyService midUserCategoryVoteApplyService;

  @PostMapping("/apply/manager")
  @ApiOperation(value = "申请版主投票")
  public RespVO<Boolean> applyVote(@RequestBody Long voteId) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(midUserCategoryVoteApplyService.applyVote(voteId, userId));
  }
}
