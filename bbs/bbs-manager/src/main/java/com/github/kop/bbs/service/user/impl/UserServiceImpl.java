package com.github.kop.bbs.service.user.impl;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.LoginUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.module.res.user.UserLoginRes;
import com.github.kop.bbs.repo.UserRepository;
import com.github.kop.bbs.service.user.MidUserRoleService;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.JwtTokenUtil;
import com.github.kop.bbs.utils.UpdateValidate;
import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

  protected final UserCreateAndUpdateValidate userCreateAndUpdateValidate =
      new UserCreateAndUpdateValidate();

  @Resource private JwtTokenUtil jwtTokenUtil;

  @Resource private UserRepository userRepository;

  @Resource private MidUserRoleService midUserRoleService;

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean create(CreateUserReq req) {
    userCreateAndUpdateValidate.createValidate(req);
    // 随机生成盐
    String salt = RandomStringUtils.randomAlphanumeric(10);
    User user =
        User.builder()
            .username(req.getUsername())
            .password(
                DigestUtils.md5DigestAsHex(
                    (req.getPassword() + salt).getBytes(StandardCharsets.UTF_8)))
            .salt(salt)
            .avatar(req.getAvatar())
            .nickname(req.getNickname())
            .build();
    boolean b = userRepository.insert(user) > 0;
    if (!b) {
      throw new NoceException("系统错误,请稍后重试");
    }
    // 添加普通角色
    MidUserRole role =
        MidUserRole.builder()
            .userId(user.getId())
            .roleId(RoleEnum.USER.getRoleId())
            .roleCode(RoleEnum.USER.getRoleCode())
            .deleted(DeletedEnum.FALSE.getCode())
            .build();
    boolean roleExist =
        midUserRoleService.existsUserRole(user.getId(), RoleEnum.USER.getRoleCode());
    if (!roleExist) {
      midUserRoleService.addUserRole(role);
    }
    return true;
  }

  @Override
  public Boolean updateUser(UpdateUserReq req) {
    User user = userRepository.selectById(req.getId());
    if (ObjectUtils.isEmpty(user)) {
      throw new NoceException("当前用户不存在");
    }
    // 修改密码重新生成盐
    if (ObjectUtils.isNotEmpty(req.getPassword())) {
      String salt = RandomStringUtils.randomAlphanumeric(10);
      user.setSalt(salt);
      user.setPassword(
          DigestUtils.md5DigestAsHex((req.getPassword() + salt).getBytes(StandardCharsets.UTF_8)));
    }
    if (ObjectUtils.isNotEmpty(req.getNickname())) {
      user.setNickname(req.getNickname());
    }
    if (ObjectUtils.isNotEmpty(req.getAvatar())) {
      user.setAvatar(req.getAvatar());
    }
    return userRepository.updateById(user) > 0;
  }

  /**
   * 登录
   *
   * @param req
   * @return
   */
  @Override
  public UserLoginRes login(LoginUserReq req) {

    User user = userRepository.findByName(req.getUsername());
    if (ObjectUtils.isEmpty(user)) {
      throw new NoceException("用户不存在!");
    }
    if (!user.getPassword()
        .equals(
            DigestUtils.md5DigestAsHex(
                (req.getPassword() + user.getSalt()).getBytes(StandardCharsets.UTF_8)))) {
      throw new NoceException("密码不正确!");
    }
    UserLoginRes res = new UserLoginRes();
    res.setUsername(user.getUsername());
    res.setAvatar(user.getAvatar());
    res.setNickname(user.getNickname());
    res.setToken(jwtTokenUtil.generateToken(user.getId()));
    return res;
  }

  protected class UserCreateAndUpdateValidate
      implements CreateValidate<CreateUserReq>, UpdateValidate<UpdateUserReq> {
    @Override
    public void createValidate(CreateUserReq createUserReq) throws ValidateException {
      String name = createUserReq.getUsername();
      if (StringUtils.isEmpty(name)) {
        throw new ValidateException("用户名必填");
      }

      boolean existsName = userRepository.existsUserName(name);
      if (existsName) {
        throw new ValidateException("用户名已存在");
      }
      String password = createUserReq.getPassword();
      if (StringUtils.isEmpty(password)) {
        throw new ValidateException("密码必填");
      }
    }

    @Override
    public void updateValidate(UpdateUserReq updateUserReq) throws ValidateException {}
  }
}
