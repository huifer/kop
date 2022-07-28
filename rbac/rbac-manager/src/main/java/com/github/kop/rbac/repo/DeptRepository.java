package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacDept;
import com.github.kop.rbac.module.req.dept.CreateDeptReq;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import com.github.kop.rbac.module.req.dept.UpdateDeptReq;

import java.util.List;

public interface DeptRepository {

    RbacDept byId(Long id);


    int deleteById(Long id);


    IPage<RbacDept> page(Long page, Long size, QueryDeptReq req);

    List<RbacDept> list(QueryDeptReq req);

    int create(RbacDept rbacDept);

    int update(RbacDept rbacDept);

    List<RbacDept> findByCompanyId(Long companyId);

    List<RbacDept> findByDeptIdForChild(Long deptId);
}
