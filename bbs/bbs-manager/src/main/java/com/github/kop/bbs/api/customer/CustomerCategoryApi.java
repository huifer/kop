package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.category.customer.CategoryListRes;
import com.github.kop.bbs.module.res.category.customer.CategoryVoteListRes;
import com.github.kop.bbs.service.category.CategoryService;
import com.github.kop.bbs.service.category.MidUserCategoryVoteApplyService;
import com.github.kop.bbs.service.category.VoteTicketCountService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "消费者-版块相关接口")
@RestController
@RequestMapping("/customer/category")
public class CustomerCategoryApi {

  @Autowired
  private CategoryService bbsCategoryService;

  @Resource
  private MidUserCategoryVoteApplyService midUserCategoryVoteApplyService;

  @Resource
  private VoteTicketCountService voteTicketCountService;

  @PostMapping("/apply/manager")
  @ApiOperation(value = "申请版主投票")
  public RespVO<Boolean> applyVote(@RequestBody Long voteSettingId) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(midUserCategoryVoteApplyService.applyVote(voteSettingId, userId));
  }

  @PostMapping("/add/vote/ticket")
  @ApiOperation(value = "版主投票")
  public RespVO<Boolean> addVoteTicket(@RequestBody Long applyId) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(voteTicketCountService.addVoteTicket(applyId, userId));
  }

  @GetMapping("/get/category/vote/list/{categoryId}")
  @ApiOperation(value = "根据分类获取进行中的版主投票列表")
  public RespVO<CategoryVoteListRes> getCategoryVoteList(@PathVariable("categoryId") Long categoryId) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(midUserCategoryVoteApplyService.getCategoryVoteList(categoryId,userId));
  }


  @ApiOperation(value = "顶层板块列表")
  @GetMapping("/top_list/")
  public RespVO<List<CategoryListRes>> list() {
    return RespVO.success(bbsCategoryService.topList());
  }

  @ApiOperation(value = "板块下属列表")
  @GetMapping("/sub_list/{category_id}")
  public RespVO<List<CategoryListRes>> subList(
      @PathVariable("category_id") Long categoryId
  ) {
    return RespVO.success(bbsCategoryService.subList(categoryId));

  }
}
