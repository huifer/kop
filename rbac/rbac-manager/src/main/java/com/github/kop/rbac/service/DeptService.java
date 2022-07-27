package com.github.kop.rbac.service;

import com.github.kop.rbac.module.req.dept.CreateDeptReq;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import com.github.kop.rbac.module.req.dept.UpdateDeptReq;
import com.github.kop.rbac.module.res.dept.DeptQueryRes;

import java.util.List;

public interface DeptService {
    List<DeptQueryRes> tree(QueryDeptReq req);

    List<DeptQueryRes> list(QueryDeptReq req);

    int deleteById(Long id);

    DeptQueryRes byId(Long id);

    int update(UpdateDeptReq req);

    int create(CreateDeptReq req);
}
