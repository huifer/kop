package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.Role;
import java.util.List;

public interface RoleRepository {

  Role byCode(String roleCode);

  List<Role> listById(List<Long> roleIds);

  List<Role> byCodeAndRoleId(List<Long> roleIds, List<String> toCheck);

  List<Role> list();

}
