package com.github.kop.bbs.service.user.relation.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.entity.UserFollowerList;
import com.github.kop.bbs.module.res.user.UserRelationResp;
import com.github.kop.bbs.repo.UserFollowerListRepository;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.service.user.relation.UserFollowerListService;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFollowerListServiceImpl implements UserFollowerListService {


  @Autowired
  private UserFollowerListRepository userFollowerListRepository;
  @Autowired
  private UserService userService;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean subscribe(Long userId, Long targetUserId) {
    UserFollowerList userFollowerList = new UserFollowerList();
    userFollowerList.setFollowerUserId(targetUserId);
    userFollowerList.setCreateUserId(userId);

    return this.userFollowerListRepository.create(userFollowerList) > 0;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean unSubscribe(Long userId, Long targetUserId) {
    return this.userFollowerListRepository.deleteByUserIdAndTargetUserId(userId, targetUserId) > 0;
  }

  @Override
  public IPage<UserRelationResp> page(Long userId, Long page, Long size) {
    IPage<UserFollowerList> pageRes = this.userFollowerListRepository.page(userId, page, size);
    return pageRes.convert(new Function<UserFollowerList, UserRelationResp>() {
      @Override
      public UserRelationResp apply(UserFollowerList userFollowerList) {
        UserRelationResp userRelationResp = new UserRelationResp();
        Long followerUserId = userFollowerList.getFollowerUserId();
        userRelationResp.setUserId(followerUserId);
        User user = userService.byUserId(followerUserId);
        userRelationResp.setUserName(user.getUsername());
        userRelationResp.setAvatar(user.getAvatar());
        userRelationResp.setNickname(user.getNickname());
        return userRelationResp;
      }
    });
  }
}
