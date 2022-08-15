package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.Role;

public interface RoleRepository {

  Role byCode(String roleCode);
}
