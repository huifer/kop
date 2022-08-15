package com.github.kop.rbac.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.app.CreateAppReq;
import com.github.kop.rbac.module.req.app.QueryAppReq;
import com.github.kop.rbac.module.req.app.UpdateAppReq;
import com.github.kop.rbac.module.res.RespVO;
import com.github.kop.rbac.module.res.app.AppQueryRes;
import com.github.kop.rbac.service.AppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "应用接口")
@RestController
@RequestMapping("/应用")
public class AppController {
  @Autowired private AppService appService;

  @ApiOperation(value = "创建应用")
  @PostMapping("/")
  public RespVO<Boolean> create(@RequestBody CreateAppReq req) {
    return RespVO.success(appService.create(req) > 1);
  }

  @ApiOperation(value = "修改应用")
  @PutMapping("/{id}")
  public RespVO<Boolean> update(
      @PathVariable(value = "id") Long id, @RequestBody UpdateAppReq req) {

    req.setId(id);
    return RespVO.success(appService.update(req) > 1);
  }

  @ApiOperation(value = "获取应用信息")
  @GetMapping("/{id}")
  public RespVO<AppQueryRes> byId(@PathVariable(value = "id") Long id) {
    return RespVO.success(appService.byId(id));
  }

  @ApiOperation(value = "删除应用")
  @DeleteMapping("/{id}")
  public RespVO<Boolean> deleteById(@PathVariable(value = "id") Long id) {

    return RespVO.success(appService.deleteById(id) > 1);
  }

  @ApiOperation(value = "应用查询分页信息")
  @GetMapping("/{page}/{size}")
  public RespVO<IPage<AppQueryRes>> page(
      @PathVariable(value = "page") Long page,
      @PathVariable(value = "size") Long size,
      @RequestBody QueryAppReq req) {

    return RespVO.success(appService.page(page, size, req));
  }

  @ApiOperation(value = "应用列表")
  @GetMapping("/list")
  public RespVO<List<AppQueryRes>> list(@RequestBody QueryAppReq req) {

    return RespVO.success(appService.list(req));
  }
}
