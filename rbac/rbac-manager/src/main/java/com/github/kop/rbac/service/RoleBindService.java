package com.github.kop.rbac.service;

public interface RoleBindService {
  boolean bindGroup();

  boolean bindResource();

  boolean bindResources();
}
