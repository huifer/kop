package com.github.kop.rbac.service.impl;

import com.github.kop.rbac.module.req.dept.CreateDeptReq;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import com.github.kop.rbac.module.req.dept.UpdateDeptReq;
import com.github.kop.rbac.module.res.dept.DeptQueryRes;
import com.github.kop.rbac.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Override
    public List<DeptQueryRes> tree(QueryDeptReq req) {
        return null;
    }

    @Override
    public List<DeptQueryRes> list(QueryDeptReq req) {
        return null;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

    @Override
    public DeptQueryRes byId(Long id) {
        return null;
    }

    @Override
    public int update(UpdateDeptReq req) {
        return 0;
    }

    @Override
    public int create(CreateDeptReq req) {
        return 0;
    }
}
