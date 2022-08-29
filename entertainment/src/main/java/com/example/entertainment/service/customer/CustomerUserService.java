package com.example.entertainment.service.customer;

import com.example.entertainment.module.customer.req.user.CustomerLoginUserReq;
import com.example.entertainment.module.customer.req.user.CustomerRegisterUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUpdateUserReq;
import com.example.entertainment.module.customer.req.user.CustomerUserVerifiedReq;
import com.example.entertainment.module.customer.resp.user.CustomerUserInfoResp;

public interface CustomerUserService {

  boolean register(CustomerRegisterUserReq req);

  CustomerUserInfoResp login(CustomerLoginUserReq req);

  CustomerUserInfoResp userInfo(String token);


  boolean author(CustomerUserVerifiedReq req);

  boolean update(String token, CustomerUpdateUserReq req);
}
