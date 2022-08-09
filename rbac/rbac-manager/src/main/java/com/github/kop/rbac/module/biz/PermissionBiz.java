package com.github.kop.rbac.module.biz;

import lombok.Data;

import java.util.List;

@Data
public class PermissionBiz {
    private String appName;
    private String appCode;
    private List<String> menus;
    private List<String> btns;
    private List<String> uris;
}
