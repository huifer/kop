package com.github.kop.bbs.api.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.score.CreateScoreRoleReq;
import com.github.kop.bbs.module.req.score.PageListScoreRoleReq;
import com.github.kop.bbs.module.req.score.UpdateScoreRoleReq;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.score.ScorePageListRes;
import com.github.kop.bbs.service.score.ScoreRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @auth ahxiaoqi
 * @desc 积分配置接口
 * @time 2022/8/14 14:34
 */
@Api(tags = "管理端-积分配置接口")
@RestController
@RequestMapping("/score")
public class ScoreController {

  @Resource private ScoreRoleService scoreRoleService;

  @ApiOperation(value = "添加积分规则")
  @PostMapping("/create")
  public RespVO<Boolean> create(@RequestBody CreateScoreRoleReq req) {
    return RespVO.success(scoreRoleService.create(req));
  }

  @ApiOperation(value = "更新积分规则")
  @PutMapping("/{id}")
  public RespVO<Boolean> update(@PathVariable("id") Long id, @RequestBody UpdateScoreRoleReq req) {
    req.setScoreRuleId(id);
    return RespVO.success(scoreRoleService.update(req));
  }

  @ApiOperation(value = "删除积分规则")
  @DeleteMapping("/{id}")
  public RespVO<Boolean> delete(@PathVariable("id") Long id) {
    return RespVO.success(scoreRoleService.delete(id));
  }

  @ApiOperation(value = "查看积分规则列表")
  @GetMapping("/{page}/{size}")
  public RespVO<IPage<ScorePageListRes>> pageList(
      @RequestBody PageListScoreRoleReq pageListScoreRoleReq,
      @PathVariable("page") Long page,
      @PathVariable("size") Long size) {
    return RespVO.success(scoreRoleService.pageList(pageListScoreRoleReq, page, size));
  }
}
