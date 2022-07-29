package com.github.kop.rbac.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.role.group.CreateRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.QueryRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.UpdateRoleGroupReq;
import com.github.kop.rbac.module.res.RespVO;
import com.github.kop.rbac.module.res.role.group.RoleGroupQueryRes;
import com.github.kop.rbac.service.RoleGroupService;
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

@Api(value = "角色组接口")
@RestController
@RequestMapping("/roule_group")
public class RoleGroupController {
  @Autowired private RoleGroupService roleGroupService;

  @ApiOperation(value = "创建角色组")
  @PostMapping("/")
  public RespVO<Boolean> create(@RequestBody CreateRoleGroupReq req) {
    return RespVO.success(roleGroupService.create(req) > 0);
  }

  @ApiOperation(value = "修改角色组")
  @PutMapping("/{id}")
  public RespVO<Boolean> update(
      @PathVariable(value = "id") Long id, @RequestBody UpdateRoleGroupReq req) {
    req.setId(id);
    return RespVO.success(roleGroupService.update(req) > 0);
  }

  @ApiOperation(value = "获取角色组信息")
  @GetMapping("/{id}")
  public RespVO<RoleGroupQueryRes> byId(@PathVariable(value = "id") Long id) {
    return RespVO.success(roleGroupService.byId(id));
  }

  @ApiOperation(value = "删除角色组")
  @DeleteMapping("/{id}")
  public RespVO<Boolean> deleteById(@PathVariable(value = "id") Long id) {

    return RespVO.success(roleGroupService.deleteById(id) > 0);
  }

  @ApiOperation(value = "角色组查询分页信息")
  @GetMapping("/{page}/{size}")
  public RespVO<IPage<RoleGroupQueryRes>> page(
      @PathVariable(value = "page") Long page,
      @PathVariable(value = "size") Long size,
      @RequestBody QueryRoleGroupReq req) {

    return RespVO.success(roleGroupService.page(page, size, req));
  }

  @ApiOperation(value = "角色组列表")
  @GetMapping("/list")
  public RespVO<List<RoleGroupQueryRes>> list(@RequestBody QueryRoleGroupReq req) {

    return RespVO.success(roleGroupService.list(req));
  }
}
