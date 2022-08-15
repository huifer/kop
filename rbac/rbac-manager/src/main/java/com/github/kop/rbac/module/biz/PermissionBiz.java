package com.github.kop.rbac.module.biz;

import java.util.List;
import lombok.Data;

@Data
public class PermissionBiz {
  private String appName;
  private String appCode;
  private List<String> menus;
  private List<String> btns;
  private List<String> uris;
}
