package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.rbac.module.entity.RbacRoleBindResource;
import com.github.kop.rbac.repo.RoleBindResourceRepository;
import com.github.kop.rbac.repo.mapper.RbacRoleBindResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class RoleBindResourceRepositoryImpl implements RoleBindResourceRepository {
    @Autowired
    private RbacRoleBindResourceMapper rbacRoleBindResourceMapper;

    @Override
    public int create(RbacRoleBindResource rbacRoleBindResource) {
        return rbacRoleBindResourceMapper.insert(rbacRoleBindResource);
    }

    @Override
    public int delete(RbacRoleBindResource rbacRoleBindResource) {
        QueryWrapper<RbacRoleBindResource> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(RbacRoleBindResource::getResourceId, rbacRoleBindResource.getResourceId())
                .eq(RbacRoleBindResource::getRoleId, rbacRoleBindResource.getRoleId());
        return rbacRoleBindResourceMapper.delete(queryWrapper);
    }

    @Override
    public List<Long> findResourceIds(Long roleId) {
        return rbacRoleBindResourceMapper.findResourceIds(Collections.singletonList(roleId));
    }

    @Override
    public List<Long> findResourceIds(List<Long> roleIds) {
        return rbacRoleBindResourceMapper.findResourceIds(roleIds);

    }
}
