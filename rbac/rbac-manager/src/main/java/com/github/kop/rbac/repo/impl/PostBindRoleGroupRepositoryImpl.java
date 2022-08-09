package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.rbac.module.entity.RbacPostBindRoleGroup;
import com.github.kop.rbac.repo.PostBindRoleGroupRepository;
import com.github.kop.rbac.repo.mapper.RbacPostBindRoleGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PostBindRoleGroupRepositoryImpl implements PostBindRoleGroupRepository {
    @Autowired
    private RbacPostBindRoleGroupMapper postBindRoleGroupMapper;

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int create(RbacPostBindRoleGroup rbacPostBindRoleGroup) {
        return postBindRoleGroupMapper.insert(rbacPostBindRoleGroup);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int delete(RbacPostBindRoleGroup rbacPostBindRoleGroup) {
        QueryWrapper<RbacPostBindRoleGroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(RbacPostBindRoleGroup::getPostId, rbacPostBindRoleGroup.getPostId())
                .eq(RbacPostBindRoleGroup::getRoleGroupId, rbacPostBindRoleGroup.getRoleGroupId());
        return postBindRoleGroupMapper.delete(queryWrapper);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public boolean create(List<RbacPostBindRoleGroup> ins) {
        for (RbacPostBindRoleGroup in : ins) {
            this.create(in);
        }
        return true;
    }

    @Override
    public List<Long> findRoleGroupIds(Long postId) {
        return this.postBindRoleGroupMapper.findRoleGroupIds(postId);
    }
}

