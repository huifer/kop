package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacRole;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.role.CreateRoleReq;
import com.github.kop.rbac.module.req.role.QueryRoleReq;
import com.github.kop.rbac.module.req.role.UpdateRoleReq;
import com.github.kop.rbac.module.res.role.RoleQueryRes;
import com.github.kop.rbac.repo.RoleRepository;
import com.github.kop.rbac.service.RoleService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import com.github.kop.rbac.utils.UserInfoThread;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  protected final RoleCreateAndUpdateValidate roleCreateAndUpdateValidate =
      new RoleCreateAndUpdateValidate();
  private final RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  private RoleQueryRes conv(RbacRole rbacRole) {
    RoleQueryRes roleQueryRes = new RoleQueryRes();
    roleQueryRes.setCode(rbacRole.getCode());
    roleQueryRes.setName(rbacRole.getName());
    roleQueryRes.setDesc(rbacRole.getDesc());
    roleQueryRes.setId(rbacRole.getId());
    return roleQueryRes;
  }

  @Override
  public List<RoleQueryRes> list(QueryRoleReq req) {
    List<RbacRole> list = this.roleRepository.list(req);
    List<RoleQueryRes> res = new ArrayList<>();
    for (RbacRole rbacRole : list) {
      res.add(conv(rbacRole));
    }
    return res;
  }

  @Override
  public int create(CreateRoleReq req) {
    roleCreateAndUpdateValidate.createValidate(req);

    RbacRole rbacRole = new RbacRole();
    rbacRole.setCode(req.getCode());
    rbacRole.setName(req.getName());
    rbacRole.setDesc(req.getDesc());
    rbacRole.setCompanyId(UserInfoThread.getCompanyId());
    return this.roleRepository.create(rbacRole);
  }

  @Override
  public int update(UpdateRoleReq req) {
    roleCreateAndUpdateValidate.updateValidate(req);
    RbacRole rbacRole = this.roleRepository.byId(req.getId());
    if (rbacRole != null) {

      if (StringUtils.isNotBlank(req.getName())) {
        rbacRole.setName(req.getName());
      }
      if (StringUtils.isNotBlank(req.getDesc())) {
        rbacRole.setDesc(req.getDesc());
      }
      rbacRole.setCompanyId(UserInfoThread.getCompanyId());
      return this.roleRepository.update(rbacRole);
    }

    return -1;
  }

  @Override
  public RoleQueryRes byId(Long id) {
    RbacRole rbacRole = this.roleRepository.byId(id);
    if (rbacRole != null) {

      RoleQueryRes roleQueryRes = conv(rbacRole);

      return roleQueryRes;
    }
    return null;
  }

  @Override
  public int deleteById(Long id) {
    return this.roleRepository.delete(id);
  }

  @Override
  public IPage<RoleQueryRes> page(Long page, Long size, QueryRoleReq req) {
    IPage<RbacRole> iPage = this.roleRepository.page(page, size, req);
    return iPage.convert(this::conv);
  }

  protected class RoleCreateAndUpdateValidate
      implements CreateValidate<CreateRoleReq>, UpdateValidate<UpdateRoleReq> {

    @Override
    public void createValidate(CreateRoleReq createRoleReq) throws ValidateException {
      String code = createRoleReq.getCode();
      if (code != null) {
        boolean b = roleRepository.exists(code);
        if (b) {
          throw new ValidateException("当前角色编码已存在");
        }
      }
      String name = createRoleReq.getName();
      if (StringUtils.isNotBlank(name)) {
        throw new ValidateException("角色名称必填");
      }
    }

    @Override
    public void updateValidate(UpdateRoleReq updateRoleReq) throws ValidateException {
      idValidate(updateRoleReq.getId());
      String name = updateRoleReq.getName();
      if (StringUtils.isNotBlank(name)) {
        throw new ValidateException("角色名称必填");
      }
    }
  }
}
