package com.example.entertainment.service.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.Users;
import com.example.entertainment.module.manager.req.user.ManagerUserQueryReq;
import com.example.entertainment.module.manager.resp.user.ManagerUserInfoResp;
import com.example.entertainment.module.manager.resp.user.ManagerUserResp;

public interface ManagerUserService {

  boolean create(Users users);

  boolean update(Users users);

  ManagerUserResp byId(int userId);

  IPage<ManagerUserResp> query(int page, int size, ManagerUserQueryReq req);

  ManagerUserInfoResp login(Users users);
}
