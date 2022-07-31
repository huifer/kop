package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacRoleGroup;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.role.group.CreateRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.QueryRoleGroupReq;
import com.github.kop.rbac.module.req.role.group.UpdateRoleGroupReq;
import com.github.kop.rbac.module.res.role.group.RoleGroupQueryRes;
import com.github.kop.rbac.repo.RoleGroupRepository;
import com.github.kop.rbac.service.RoleGroupService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleGroupServiceImpl implements RoleGroupService {

  protected final RoleGroupCreateAndUpdateValidate roleGroupCreateAndUpdateValidate =
      new RoleGroupCreateAndUpdateValidate();
  @Autowired
  private RoleGroupRepository roleGroupRepository;

  @Override
  public int create(CreateRoleGroupReq req) {
    roleGroupCreateAndUpdateValidate.createValidate(req);
    RbacRoleGroup rbacRoleGroup = new RbacRoleGroup();
    rbacRoleGroup.setName(req.getName());
    return roleGroupRepository.create(rbacRoleGroup);
  }

  @Override
  public int update(UpdateRoleGroupReq req) {
    roleGroupCreateAndUpdateValidate.updateValidate(req);
    RbacRoleGroup rbacRoleGroup = this.roleGroupRepository.byId(req.getId());
    if (rbacRoleGroup != null) {
      if (StringUtils.isNotBlank(req.getName())) {
        rbacRoleGroup.setName(req.getName());
      }
      return this.roleGroupRepository.update(rbacRoleGroup);
    }

    return -1;
  }

  @Override
  public RoleGroupQueryRes byId(Long id) {
    RbacRoleGroup rbacRoleGroup = this.roleGroupRepository.byId(id);
    if (rbacRoleGroup != null) {

      return conv(rbacRoleGroup);

    }
    return null;
  }


  private RoleGroupQueryRes conv(RbacRoleGroup rbacRoleGroup) {
    RoleGroupQueryRes roleGroupQueryRes = new RoleGroupQueryRes();
    roleGroupQueryRes.setName(rbacRoleGroup.getName());
    roleGroupQueryRes.setId(rbacRoleGroup.getId());
    return roleGroupQueryRes;
  }

  @Override
  public int deleteById(Long id) {
    return this.roleGroupRepository.delete(id);
  }

  @Override
  public IPage<RoleGroupQueryRes> page(Long page, Long size, QueryRoleGroupReq req) {
    IPage<RbacRoleGroup> iPage = this.roleGroupRepository.page(page, size, req);
    return iPage.convert(this::conv);
  }

  @Override
  public List<RoleGroupQueryRes> list(QueryRoleGroupReq req) {
    List<RbacRoleGroup> list = this.roleGroupRepository.list(req);

    List<RoleGroupQueryRes> res = new ArrayList<>();
    for (RbacRoleGroup rbacRoleGroup : list) {
      res.add(conv(rbacRoleGroup));
    }
    return res;
  }

  protected class RoleGroupCreateAndUpdateValidate
      implements CreateValidate<CreateRoleGroupReq>, UpdateValidate<UpdateRoleGroupReq> {

    @Override
    public void createValidate(CreateRoleGroupReq createRoleGroupReq) throws ValidateException {
      String name = createRoleGroupReq.getName();
      if (StringUtils.isNotBlank(name)) {
        throw new ValidateException("角色组名称必填");
      }
      boolean b = roleGroupRepository.exists(name);
      if (b) {
        throw new ValidateException("角色组名称已存在");
      }
    }

    @Override
    public void updateValidate(UpdateRoleGroupReq updateRoleGroupReq) throws ValidateException {
      idValidate(updateRoleGroupReq.getId());
      String name = updateRoleGroupReq.getName();
      if (StringUtils.isNotBlank(name)) {
        throw new ValidateException("角色组名称必填");
      }
      boolean b = roleGroupRepository.exists(name);
      if (b) {
        throw new ValidateException("角色组名称已存在");
      }
    }
  }
}
