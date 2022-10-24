package com.github.kop.bbs.service.user.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.entity.UserDynamic;
import com.github.kop.bbs.module.req.user.UserDynamicCreateReq;
import com.github.kop.bbs.module.res.user.UserDynamicResp;
import com.github.kop.bbs.repo.UserDynamicRepository;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.service.user.dynamic.UserDynamicService;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDynamicServiceImpl implements UserDynamicService {

  @Autowired private UserDynamicRepository userDynamicRepository;
  @Autowired private UserService userService;

  @Override
  public boolean create(UserDynamicCreateReq req, Long userId) {
    UserDynamic userDynamic = new UserDynamic();
    userDynamic.setTopicId(req.getTopicId());
    userDynamic.setContent(req.getContent());
    userDynamic.setCreateUserId(userId);

    return userDynamicRepository.create(userDynamic) > 0;
  }

  @Override
  public IPage<UserDynamicResp> page(Long userId, Long page, Long size) {
    IPage<UserDynamic> dynamicIPage = this.userDynamicRepository.page(userId, page, size);
    return dynamicIPage.convert(
        new Function<UserDynamic, UserDynamicResp>() {
          @Override
          public UserDynamicResp apply(UserDynamic userDynamic) {
            UserDynamicResp userDynamicResp = new UserDynamicResp();
            userDynamicResp.setTopicId(userDynamic.getTopicId());
            userDynamicResp.setContent(userDynamic.getContent());
            Long createUserId = userDynamic.getCreateUserId();
            User user = userService.byUserId(createUserId);
            userDynamicResp.setUsername(user.getUsername());
            userDynamicResp.setNickname(user.getNickname());
            userDynamicResp.setCreateTime(userDynamic.getCreateTime());

            // TODO: 2022/8/23 点赞数、踩数统计
            //        userDynamicResp.setLikes();
            //        userDynamicResp.setDislikes();

            return userDynamicResp;
          }
        });
  }

  @Override
  public boolean delete(Long userId, Long id) {
    return this.userDynamicRepository.delete(userId, id) > 0;
  }
}
