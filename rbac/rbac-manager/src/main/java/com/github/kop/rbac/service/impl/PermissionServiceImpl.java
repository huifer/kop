package com.github.kop.rbac.service.impl;

import com.github.kop.rbac.module.biz.PermissionBiz;
import com.github.kop.rbac.service.PermissionService;
import com.github.kop.rbac.service.PostService;
import com.github.kop.rbac.service.RoleBindService;
import com.github.kop.rbac.service.RoleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PostService postService;
    @Autowired
    private RoleBindService roleBindService;


    @Override
    public PermissionBiz generatorPermission(Long postId) {
        List<Long> roleGroupIds = postService.findRoleGroupIds(postId);

        return null;
    }
}
