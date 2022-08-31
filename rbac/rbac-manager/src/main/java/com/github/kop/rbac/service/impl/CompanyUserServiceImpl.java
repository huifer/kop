package com.github.kop.rbac.service.impl;


import com.github.kop.rbac.module.entity.RbacCompanyUser;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.companyUser.CompanyUserReq;
import com.github.kop.rbac.repo.CompanyUserRepository;
import com.github.kop.rbac.service.CompanyUserService;
import com.github.kop.rbac.utils.CreateValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyUserServiceImpl implements CompanyUserService {

    private final CompanyUserCreateAndUpdateValidate companyUserCreateAndUpdateValidate =
            new CompanyUserCreateAndUpdateValidate();
    @Autowired
    private CompanyUserRepository companyUserRepository;

    @Override
    public int createCompanyUser(CompanyUserReq req) {
        companyUserCreateAndUpdateValidate.createValidate(req);
        RbacCompanyUser rbacCompanyUser = new RbacCompanyUser();
        rbacCompanyUser.setCompanyId(req.getCompanyId());
        rbacCompanyUser.setUserId(req.getUserId());

        return companyUserRepository.createCompanyUser(rbacCompanyUser);
    }

    protected static final class CompanyUserCreateAndUpdateValidate implements CreateValidate<CompanyUserReq> {


        @Override
        public void createValidate(CompanyUserReq req) throws ValidateException {
            if (req == null || req.getCompanyId() == null || req.getUserId() == null) {
                throw new ValidateException("参数不正确");
            }
        }
    }
}
