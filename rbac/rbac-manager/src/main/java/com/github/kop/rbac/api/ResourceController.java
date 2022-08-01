package com.github.kop.rbac.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.enums.ResourceTypeEnum;
import com.github.kop.rbac.module.req.resource.CreateResourceReq;
import com.github.kop.rbac.module.req.resource.QueryResourceReq;
import com.github.kop.rbac.module.req.resource.UpdateResourceReq;
import com.github.kop.rbac.module.res.EnumsResp;
import com.github.kop.rbac.module.res.RespVO;
import com.github.kop.rbac.module.res.resource.ResourceQueryRes;
import com.github.kop.rbac.service.ResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
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

@Api(value = "资源接口")
@RestController
@RequestMapping("/resources")
public class ResourceController {

  @Autowired private ResourceService resourceService;

  @ApiOperation(value = "创建资源")
  @PostMapping("/")
  public RespVO<Boolean> create(@RequestBody CreateResourceReq req) {
    return RespVO.success(resourceService.create(req) > 0);
  }

  @ApiOperation(value = "修改资源")
  @PutMapping("/{id}")
  public RespVO<Boolean> update(
      @PathVariable(value = "id") Long id, @RequestBody UpdateResourceReq req) {
    req.setId(id);
    return RespVO.success(resourceService.update(req) > 0);
  }

  @ApiOperation(value = "获取资源信息")
  @GetMapping("/{id}")
  public RespVO<ResourceQueryRes> byId(@PathVariable(value = "id") Long id) {
    return RespVO.success(resourceService.byId(id));
  }

  @ApiOperation(value = "删除资源")
  @DeleteMapping("/{id}")
  public RespVO<Boolean> deleteById(@PathVariable(value = "id") Long id) {

    return RespVO.success(resourceService.deleteById(id) > 0);
  }

  @ApiOperation(value = "资源查询分页信息")
  @GetMapping("/{page}/{size}")
  public RespVO<IPage<ResourceQueryRes>> page(
      @PathVariable(value = "page") Long page,
      @PathVariable(value = "size") Long size,
      @RequestBody QueryResourceReq req) {

    return RespVO.success(resourceService.page(page, size, req));
  }

  @ApiOperation(value = "资源列表")
  @GetMapping("/list")
  public RespVO<List<ResourceQueryRes>> list(@RequestBody QueryResourceReq req) {

    return RespVO.success(resourceService.list(req));
  }

  @ApiOperation(value = "枚举项")
  @GetMapping("/enums")
  public RespVO<List<EnumsResp>> enums() {
    List<EnumsResp> res = new ArrayList<>();
    for (ResourceTypeEnum value : ResourceTypeEnum.values()) {
      res.add(EnumsResp.builder().code(value.getCode()).msg(value.getName()).build());
    }
    return RespVO.success(res);
  }
}
