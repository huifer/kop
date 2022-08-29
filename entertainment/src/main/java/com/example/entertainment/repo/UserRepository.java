package com.example.entertainment.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.Users;
import com.example.entertainment.module.manager.req.user.ManagerUserQueryReq;

public interface UserRepository {

  boolean hasInvitationCode(String code);

  Users findByUuid(String uuid);

  int  create(Users users);


  Users findByPhone(String phone);

  Users findById(int userId);

  int  updateById(Users users);

  IPage<Users> page(int page, int size, ManagerUserQueryReq req);
}
