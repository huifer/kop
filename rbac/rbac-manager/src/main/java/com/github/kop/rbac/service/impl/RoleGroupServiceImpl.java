package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.role.group.CreateRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.QueryRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.UpdateRoleGroupReq;
import com.github.kop.rbac.module.res.role.group.RoleGroupQueryRes;
import com.github.kop.rbac.repo.RoleGroupRepository;
import com.github.kop.rbac.service.RoleGroupService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleGroupServiceImpl implements RoleGroupService {
  protected final RoleGroupCreateAndUpdateValidate roleGroupCreateAndUpdateValidate =
      new RoleGroupCreateAndUpdateValidate();

  @Override
  public int create(CreateRoleGroupReq req) {
    return 0;
  }

  @Override
  public int update(UpdateRoleGroupReq req) {
    return 0;
  }

  @Override
  public RoleGroupQueryRes byId(Long id) {
    return null;
  }

  @Override
  public int deleteById(Long id) {
    return 0;
  }

  @Override
  public IPage<RoleGroupQueryRes> page(Long page, Long size, QueryRoleGroupReq req) {
    return null;
  }

  @Override
  public List<RoleGroupQueryRes> list(QueryRoleGroupReq req) {
    return null;
  }

  @Autowired private RoleGroupRepository roleGroupRepository;

  protected class RoleGroupCreateAndUpdateValidate
      implements CreateValidate<CreateRoleGroupReq>, UpdateValidate<UpdateRoleGroupReq> {
    @Override
    public void createValidate(CreateRoleGroupReq createRoleGroupReq) throws ValidateException {}

    @Override
    public void updateValidate(UpdateRoleGroupReq updateRoleGroupReq) throws ValidateException {}
  }
}
