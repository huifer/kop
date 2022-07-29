package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.role.CreateRoleReq;
import com.github.kop.rbac.module.req.role.QueryRoleReq;
import com.github.kop.rbac.module.req.role.UpdateRoleReq;
import com.github.kop.rbac.module.res.role.RoleQueryRes;
import com.github.kop.rbac.repo.RoleRepository;
import com.github.kop.rbac.service.RoleService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
  protected final RoleCreateAndUpdateValidate roleCreateAndUpdateValidate =
      new RoleCreateAndUpdateValidate();

  @Override
  public List<RoleQueryRes> list(QueryRoleReq req) {
    return null;
  }

  @Override
  public int create(CreateRoleReq req) {
    return 0;
  }

  @Override
  public int update(UpdateRoleReq req) {
    return 0;
  }

  @Override
  public RoleQueryRes byId(Long id) {
    return null;
  }

  @Override
  public int deleteById(Long id) {
    return 0;
  }

  @Override
  public IPage<RoleQueryRes> page(Long page, Long size, QueryRoleReq req) {
    return null;
  }

  @Autowired private RoleRepository roleRepository;

  protected class RoleCreateAndUpdateValidate
      implements CreateValidate<CreateRoleReq>, UpdateValidate<UpdateRoleReq> {
    @Override
    public void createValidate(CreateRoleReq createRoleReq) throws ValidateException {}

    @Override
    public void updateValidate(UpdateRoleReq updateRoleReq) throws ValidateException {}
  }
}
