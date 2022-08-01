package com.github.kop.rbac.service;

public interface UserBindService {

  /** 根据用户id和企业id获取部门名称 */
  String getBindDeptName(Long userId, Long companyId);

  /** 根据用户id和企业id获取主岗位名称 */
  String getBindMainPostName(Long userId, Long companyId);
}
