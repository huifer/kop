package com.github.kop.rbac.service;


import com.github.kop.rbac.module.req.companyUser.CompanyUserReq;

public interface CompanyUserService {

    int  createCompanyUser(CompanyUserReq req);
}
