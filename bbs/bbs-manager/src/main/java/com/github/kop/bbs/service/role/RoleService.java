package com.github.kop.bbs.service.role;

import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.module.res.role.RoleListResp;
import java.util.List;

public interface RoleService {

  Role byCode(String roleCode);

  List<Role> findByUserId(Long userId);

  /**
   * @param toCheck 带校验的角色编码
   * @param userId 用户id
   * @return
   */
  boolean hasRoleCodes(List<String> toCheck, Long userId);

  List<RoleListResp> list();

  List<Role> findByIds(List<Long> roleIds);
}
