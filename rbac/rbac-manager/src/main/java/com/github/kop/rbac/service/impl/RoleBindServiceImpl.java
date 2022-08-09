package com.github.kop.rbac.service.impl;

import com.github.kop.rbac.module.entity.RbacRoleBindGroup;
import com.github.kop.rbac.module.entity.RbacRoleBindResource;
import com.github.kop.rbac.repo.RoleBindGroupRepository;
import com.github.kop.rbac.repo.RoleBindResourceRepository;
import com.github.kop.rbac.service.RoleBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleBindServiceImpl implements RoleBindService {

    @Autowired
    private RoleBindGroupRepository roleBindGroupRepository;
    @Autowired
    private RoleBindResourceRepository roleBindResourceRepository;


    @Override
    public boolean bindGroup(Long roleId, Long roleGroupId) {
        RbacRoleBindGroup rbacRoleBindGroup = new RbacRoleBindGroup();
        rbacRoleBindGroup.setRoleGroupId(roleGroupId);
        rbacRoleBindGroup.setRoleId(roleId);

        return this.roleBindGroupRepository.create(rbacRoleBindGroup) > 0;
    }

    @Override
    public boolean bindResource(Long roleId, Long resourceId) {
        RbacRoleBindResource rbacRoleBindResource = new RbacRoleBindResource();
        rbacRoleBindResource.setResourceId(resourceId);
        rbacRoleBindResource.setRoleId(roleId);

        return roleBindResourceRepository.create(rbacRoleBindResource) > 0;
    }

    @Override
    public boolean unBindGroup(Long roleId, Long roleGroupId) {
        RbacRoleBindGroup rbacRoleBindGroup = new RbacRoleBindGroup();
        rbacRoleBindGroup.setRoleGroupId(roleGroupId);
        rbacRoleBindGroup.setRoleId(roleId);
        return this.roleBindGroupRepository.delete(rbacRoleBindGroup) > 0;
    }

    @Override
    public boolean unBindResource(Long roleId, Long resourceId) {
        RbacRoleBindResource rbacRoleBindResource = new RbacRoleBindResource();
        rbacRoleBindResource.setResourceId(resourceId);
        rbacRoleBindResource.setRoleId(roleId);
        return roleBindResourceRepository.delete(rbacRoleBindResource) > 0;
    }

    @Override
    public List<Long> findRoleIds(Long roleGroupId) {
        return this.roleBindGroupRepository.findRoleIds(roleGroupId);
    }

    @Override
    public List<Long> findRoleIds(List<Long> roleGroupIds) {
        return this.roleBindGroupRepository.findRoleIds(roleGroupIds);

    }

    @Override
    public List<Long> findResourceIds(Long roleId) {
        return roleBindResourceRepository.findResourceIds(roleId);
    }

    @Override
    public List<Long> findResourceIds(List<Long> roleIds) {
        return roleBindResourceRepository.findResourceIds(roleIds);

    }
}
