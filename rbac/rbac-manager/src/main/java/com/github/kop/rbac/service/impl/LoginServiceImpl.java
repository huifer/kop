package com.github.kop.rbac.service.impl;

import com.github.kop.rbac.module.enums.AppHttpCodeEnum;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.login.LoginReq;
import com.github.kop.rbac.module.res.user.UserLoginRes;
import com.github.kop.rbac.service.LoginService;
import com.github.kop.rbac.service.UserService;
import com.github.kop.rbac.utils.LoginValidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl  implements LoginService {

    @Autowired private UserService  userService;

    protected final LoginCheckValidate validate=new LoginCheckValidate();

    private static final class LoginCheckValidate implements LoginValidate<LoginReq>{

        @Override
        public void checkLogin(LoginReq loginReq) throws ValidateException {
            if(loginReq==null || StringUtils.isBlank(loginReq.getPassword()) || StringUtils.isBlank(loginReq.getUsername())) {
                throw new ValidateException(AppHttpCodeEnum.LOGIN_ERROR);
            }
        }
    }


    @Override
    public UserLoginRes login(LoginReq loginReq) {
        validate.checkLogin(loginReq);

        return null;
    }
}
