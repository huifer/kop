package com.example.entertainment.service.manager.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entertainment.module.entity.Users;
import com.example.entertainment.module.manager.req.user.ManagerUserQueryReq;
import com.example.entertainment.module.manager.resp.user.ManagerUserResp;
import com.example.entertainment.repo.UserRepository;
import com.example.entertainment.service.manager.ManagerUserService;
import java.util.function.Function;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerUserServiceImpl implements ManagerUserService {

  @Autowired
  private UserRepository userRepository;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(Users users) {
    String parentPhone = users.getParentPhone();
    if (!org.apache.commons.lang3.StringUtils.isEmpty(parentPhone)) {
      Users byPhone = this.userRepository.findByPhone(parentPhone);
      if (byPhone != null) {
        users.setParentMember(byPhone.getId());
        return this.userRepository.create(users) > 0;
      }

    }
    return false;
  }

  @Override
  public boolean update(Users users) {
    return this.userRepository.updateById(users) > 0;
  }

  @Override
  public ManagerUserResp byId(int userId) {
    Users byId = this.userRepository.findById(userId);
    ManagerUserResp managerUserResp = new ManagerUserResp();
    BeanUtils.copyProperties(byId, managerUserResp);
    return managerUserResp;
  }

  @Override
  public IPage<ManagerUserResp> query(int page, int size, ManagerUserQueryReq req) {
    IPage<Users> usersIPage = this.userRepository.page(page, size, req);
    return usersIPage.convert(new Function<Users, ManagerUserResp>() {
      @Override
      public ManagerUserResp apply(Users users) {
        ManagerUserResp managerUserResp = new ManagerUserResp();
        BeanUtils.copyProperties(users, managerUserResp);
        return managerUserResp;
      }
    });
  }
}
