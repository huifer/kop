package com.github.kop.bbs.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.LoginUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.module.req.user.UserQueryReq;
import com.github.kop.bbs.module.res.user.UserLoginRes;
import com.github.kop.bbs.module.res.user.UserQueryResp;

import java.util.List;

public interface UserService {

  /**
   * 添加用户
   *
   * @param req
   * @return
   */
  Boolean createCustomerUser(CreateUserReq req);

  /**
   * 更新用户
   *
   * @param req
   * @return
   */
  Boolean updateUser(UpdateUserReq req);

  /**
   * 登录
   *
   * @param req
   * @return
   */
  UserLoginRes login(LoginUserReq req);

  User byUserId(Long id);


  /**
   * 用户是否有相关角色
   * @param userId 用户id
   * @param roles 角色集合
   */
  boolean hasRoles(Long userId, RoleEnum[] roles);

  /**
   * 管理端分页查询
   */
  IPage<UserQueryResp> page(Long page, Long size, UserQueryReq req);

  List<User> findByUserIds(List<Long> userIdList);
}
