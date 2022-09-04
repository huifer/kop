package com.github.kop.bbs.api.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.category.CreateMidUserCategoryReq;
import com.github.kop.bbs.module.req.category.UserCategoryVoteSettingReq;
import com.github.kop.bbs.module.req.category.voteSettingListReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.category.manager.VoteSettingListRes;
import com.github.kop.bbs.service.category.MidUserCategoryService;
import com.github.kop.bbs.service.category.UserCategoryVoteSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 版主与分类的中间表 前端控制器
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Api(tags = "管理端-版主接口")
@RestController
@RequestMapping("/mid_user_category")
public class MidUserCategoryController {

  @Resource private MidUserCategoryService midUserCategoryService;

  @Resource
  private UserCategoryVoteSettingService userCategoryVoteSettingService;

  @ApiOperation(value = "添加版主")
  @PostMapping("/create")
  public RespVO<Boolean> create(@RequestBody CreateMidUserCategoryReq req) {
    return RespVO.success(midUserCategoryService.create(req));
  }

  @ApiOperation(value = "移除版主")
  @DeleteMapping("/{id}/{userId}")
  public RespVO<Boolean> delete(@PathVariable("id") Long id, @PathVariable("userId") Long userId) {
    return RespVO.success(midUserCategoryService.delete(id, userId));
  }

  @ApiOperation("添加投票设置")
  @PostMapping("/create_vote_setting")
  public RespVO<Boolean> createVoteSetting(@RequestBody UserCategoryVoteSettingReq req) {
    return RespVO.success(userCategoryVoteSettingService.create(req));
  }

  @ApiOperation("获取投票设置列表")
  @PostMapping("/vote_setting/list/{page}/{page_size}")
  public RespVO<IPage<VoteSettingListRes>> voteSettingList(
                                                           @PathVariable("page") Integer page,
                                                           @PathVariable("page_size") Integer pageSize,
                                                           @RequestBody voteSettingListReq req ) {
    return RespVO.success(userCategoryVoteSettingService.voteSettingList(req,page,pageSize));
  }

  // TODO: 2022/9/4 投票结束后设置版主信息

}
