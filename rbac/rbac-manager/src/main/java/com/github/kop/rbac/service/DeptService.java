package com.github.kop.rbac.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.dept.CreateDeptReq;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import com.github.kop.rbac.module.req.dept.UpdateDeptReq;
import com.github.kop.rbac.module.res.dept.DeptQueryRes;
import java.util.List;

public interface DeptService {

  List<DeptQueryRes> list(QueryDeptReq req);

  int deleteById(Long id);

  DeptQueryRes byId(Long id);

  int update(UpdateDeptReq req);

  int create(CreateDeptReq req);

  IPage<DeptQueryRes> page(Long page, Long size, QueryDeptReq req);

  List<DeptQueryRes> tree(Long companyId, Long deptId);
}
