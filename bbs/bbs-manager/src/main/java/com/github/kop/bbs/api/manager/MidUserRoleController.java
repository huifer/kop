package com.github.kop.bbs.api.manager;

import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.req.user.UserBindRoleReq;
import com.github.kop.bbs.module.res.EnumsResp;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.module.res.role.RoleListResp;
import com.github.kop.bbs.service.role.RoleService;
import com.github.kop.bbs.service.user.MidUserRoleService;
import com.github.kop.bbs.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户角色中间表 前端控制器
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Api(tags = "管理端-用户角色接口")
@RestController
@RequestMapping("/mid_user_role")
public class MidUserRoleController {

  @Autowired
  private RoleService roleService;

  @ApiOperation("角色列表")
  @GetMapping("/role_list")
  public RespVO<List<RoleListResp>> roleList() {
    return RespVO.success(roleService.list());
  }

  @Autowired
  private MidUserRoleService midUserRoleService;
  @PostMapping("/give_role")
  @ApiOperation("赋予角色")
  public RespVO<Boolean> giveRole(
      @RequestBody UserBindRoleReq userBindRoleReq
  ) {
    return RespVO.success(midUserRoleService.giveRole(UserInfoThread.getUserId(), userBindRoleReq));
  }
}
