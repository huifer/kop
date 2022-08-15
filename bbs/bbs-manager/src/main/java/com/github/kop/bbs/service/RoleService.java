package com.github.kop.bbs.service;

import com.github.kop.bbs.module.entity.Role;

public interface RoleService {

  Role byCode(String roleCode);
}
