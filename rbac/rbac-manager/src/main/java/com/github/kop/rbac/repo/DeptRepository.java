package com.github.kop.rbac.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacDept;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import java.util.List;

public interface DeptRepository {

  RbacDept byId(Long id);

  int deleteById(Long id);

  IPage<RbacDept> page(Long page, Long size, QueryDeptReq req);

  List<RbacDept> list(QueryDeptReq req);

  int create(RbacDept rbacDept);

  int update(RbacDept rbacDept);

  List<RbacDept> findByCompanyId(Long companyId);

  /**
   * 根据部门id查询所有部门，当前部门以及当前部门以下一级部门
   * @param deptId 部门id
   * @return id = deptId and pid = deptId
   */
  List<RbacDept> findByDeptIdForChild(Long deptId);

  /**
   * 根据名称查询id集合
   * @param deptName 名称
   * @return id集合
   */
  List<Long> findByName(String deptName);
}
