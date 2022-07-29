package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.user.CreateUserReq;
import com.github.kop.rbac.module.req.user.QueryUserReq;
import com.github.kop.rbac.module.req.user.UpdateUserReq;
import com.github.kop.rbac.module.res.user.UserQueryRes;
import com.github.kop.rbac.repo.UserRepository;
import com.github.kop.rbac.service.UserService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  protected final UserCreateAndUpdateValidate userCreateAndUpdateValidate =
      new UserCreateAndUpdateValidate();
  @Autowired private UserRepository userRepository;

  @Override
  public int create(CreateUserReq req) {
    return 0;
  }

  @Override
  public int update(UpdateUserReq req) {
    return 0;
  }

  @Override
  public UserQueryRes byId(Long id) {
    return null;
  }

  @Override
  public int deleteById(Long id) {
    return 0;
  }

  @Override
  public IPage<UserQueryRes> page(Long page, Long size, QueryUserReq req) {
    return null;
  }

  @Override
  public List<UserQueryRes> list(QueryUserReq req) {
    return null;
  }

  protected class UserCreateAndUpdateValidate
      implements CreateValidate<CreateUserReq>, UpdateValidate<UpdateUserReq> {
    @Override
    public void createValidate(CreateUserReq createUserReq) throws ValidateException {}

    @Override
    public void updateValidate(UpdateUserReq updateUserReq) throws ValidateException {}
  }
}
