package com.github.kop.rbac.service.impl;

import com.github.kop.rbac.module.entity.RbacUserBindDept;
import com.github.kop.rbac.module.entity.RbacUserBindPost;
import com.github.kop.rbac.module.res.dept.DeptQueryRes;
import com.github.kop.rbac.module.res.post.PostQueryRes;
import com.github.kop.rbac.repo.UserBindDeptRepository;
import com.github.kop.rbac.repo.UserBindPostRepository;
import com.github.kop.rbac.service.DeptService;
import com.github.kop.rbac.service.PostService;
import com.github.kop.rbac.service.UserBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBindServiceImpl implements UserBindService {
  @Autowired private UserBindDeptRepository userBindDeptRepository;

  @Autowired private UserBindPostRepository userBindPostRepository;
  @Autowired private DeptService deptService;
  @Autowired private PostService postService;

  @Override
  public String getBindDeptName(Long userId, Long companyId) {
    RbacUserBindDept userBindDept = this.userBindDeptRepository.getBind(userId, companyId);
    if (userBindDept != null) {
      Long deptId = userBindDept.getDeptId();
      DeptQueryRes deptQueryRes = deptService.byId(deptId);
      if (deptQueryRes != null) {
        return deptQueryRes.getName();
      }
    }
    return null;
  }

  @Override
  public String getBindMainPostName(Long userId, Long companyId) {
    RbacUserBindPost userBindPost = this.userBindPostRepository.getBind(userId, companyId);
    if (userBindPost != null) {
      Long postId = userBindPost.getPostId();
      PostQueryRes postQueryRes = postService.byId(postId);
      if (postQueryRes != null) {
        return postQueryRes.getName();
      }
    }
    return null;
  }
}
