package com.github.kop.bbs.api.customer;

import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.category.CategoryListRes;
import com.github.kop.bbs.service.category.CategoryService;
import com.github.kop.bbs.service.category.MidUserCategoryVoteService;
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

  @Resource
  private MidUserCategoryVoteService midUserCategoryVoteService;

  @PostMapping("/apply/manager")
  @ApiOperation(value = "申请版主投票")
  public RespVO<Boolean> applyVote(@RequestBody Long voteSettingId) {
    Long userId = UserInfoThread.getUserId();
    return RespVO.success(midUserCategoryVoteService.applyVote(voteSettingId, userId));
  }

  @Autowired
  private CategoryService bbsCategoryService;

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
