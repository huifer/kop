package com.github.kop.rbac.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.role.CreateRoleReq;
import com.github.kop.rbac.module.req.role.QueryRoleReq;
import com.github.kop.rbac.module.req.role.UpdateRoleReq;
import com.github.kop.rbac.module.res.RespVO;
import com.github.kop.rbac.module.res.role.RoleQueryRes;
import com.github.kop.rbac.service.RoleService;
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

@Api(value = "角色接口")
@RestController
@RequestMapping("/role")
public class RoleController {
  @Autowired private RoleService roleService;

  @ApiOperation(value = "创建角色")
  @PostMapping("/")
  public RespVO<Boolean> create(@RequestBody CreateRoleReq req) {
    return RespVO.success(roleService.create(req) > 0);
  }

  @ApiOperation(value = "修改角色")
  @PutMapping("/{id}")
  public RespVO<Boolean> update(
      @PathVariable(value = "id") Long id, @RequestBody UpdateRoleReq req) {
    req.setId(id);
    return RespVO.success(roleService.update(req) > 0);
  }

  @ApiOperation(value = "获取角色信息")
  @GetMapping("/{id}")
  public RespVO<RoleQueryRes> byId(@PathVariable(value = "id") Long id) {
    return RespVO.success(roleService.byId(id));
  }

  @ApiOperation(value = "删除角色")
  @DeleteMapping("/{id}")
  public RespVO<Boolean> deleteById(@PathVariable(value = "id") Long id) {

    return RespVO.success(roleService.deleteById(id) > 0);
  }

  @ApiOperation(value = "角色查询分页信息")
  @GetMapping("/{page}/{size}")
  public RespVO<IPage<RoleQueryRes>> page(
      @PathVariable(value = "page") Long page,
      @PathVariable(value = "size") Long size,
      @RequestBody QueryRoleReq req) {

    return RespVO.success(roleService.page(page, size, req));
  }

  @ApiOperation(value = "角色列表")
  @GetMapping("/list")
  public RespVO<List<RoleQueryRes>> list(@RequestBody QueryRoleReq req) {

    return RespVO.success(roleService.list(req));
  }
}
