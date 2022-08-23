package com.github.kop.bbs.service.user.relation.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.entity.UserBlackList;
import com.github.kop.bbs.module.entity.UserFollowerList;
import com.github.kop.bbs.module.res.user.UserRelationResp;
import com.github.kop.bbs.repo.UserBlackListRepository;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.service.user.relation.UserBlackListService;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBlackListServiceImpl implements UserBlackListService {

  @Autowired
  private UserBlackListRepository userBlackListRepository;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean pullBlack(Long userId, Long targetUserId) {
    UserBlackList userBlackList = new UserBlackList();
    userBlackList.setBlackUserId(targetUserId);
    userBlackList.setCreateUserId(userId);

    return userBlackListRepository.create(userBlackList) > 0;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean cancelBlock(Long userId, Long targetUserId) {
    return userBlackListRepository.deleteByUserIdAndTargetUserId(userId, targetUserId) > 0;
  }

  @Autowired
  private UserService userService;

  @Override
  public IPage<UserRelationResp> page(Long userId, Long page, Long size) {
    IPage<UserBlackList> pageRes = this.userBlackListRepository.page(userId, page, size);
    return pageRes.convert(new Function<UserBlackList, UserRelationResp>() {
      @Override
      public UserRelationResp apply(UserBlackList userBlackList) {
        UserRelationResp userRelationResp = new UserRelationResp();
        Long followerUserId = userBlackList.getBlackUserId();
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
