package com.github.kop.bbs.service.appeal.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Appeal;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.enums.AppealTypeEnum;
import com.github.kop.bbs.module.enums.appeal.AppealStatusEnum;
import com.github.kop.bbs.module.req.appeal.AppealManagerPageReq;
import com.github.kop.bbs.module.req.appeal.CreateAppealReq;
import com.github.kop.bbs.module.req.appeal.ReplyAppealReq;
import com.github.kop.bbs.module.res.appeal.AppealReceiptResp;
import com.github.kop.bbs.module.res.appeal.AppealResp;
import com.github.kop.bbs.repo.AppealRepository;
import com.github.kop.bbs.service.appeal.AppealService;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.utils.UserInfoThread;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppealServiceImpl implements AppealService {

  @Autowired
  private AppealRepository appealRepository;

  @Autowired
  private UserService userService;

  @Override
  public boolean create(CreateAppealReq req) {
    Appeal appeal = new Appeal();
    appeal.setAppealType(req.getAppealType());
    appeal.setAppealStatus(AppealStatusEnum.PENDING.getCode());
    appeal.setAppealTitle(req.getAppealTitle());
    appeal.setAppealText(req.getAppealText());
    appeal.setAppealFile(req.getAppealFile());
    appeal.setAppealUserId(UserInfoThread.getUserId());
    return appealRepository.create(appeal) > 0;
  }

  @Override
  public IPage<AppealResp> page(Long page, Long size, Long userId) {
    IPage<Appeal> pageRes = this.appealRepository.page(page, size,userId);
    return pageRes.convert(this::pageConvert);
  }

  @Override
  public IPage<AppealResp> page(Long page, Long size, AppealManagerPageReq req) {
    IPage<Appeal> pageRes = this.appealRepository.page(page, size,req);
    return pageRes.convert(this::pageConvert);
  }

  private AppealResp pageConvert(Appeal appeal){
    AppealResp appealResp = new AppealResp();
    appealResp.setAppealId(appeal.getAppealId());
    appealResp.setAppealType(appeal.getAppealType());
    appealResp.setAppealTypeString(AppealTypeEnum.conv(appeal.getAppealType()).getDesc());
    appealResp.setAppealStatus(appeal.getAppealStatus());
    appealResp.setAppealStatus(AppealStatusEnum.conv(appeal.getAppealStatus()).getCode());
    appealResp.setAppealTitle(appeal.getAppealTitle());
    appealResp.setAppealText(appeal.getAppealText());
    appealResp.setAppealUserId(appeal.getAppealUserId());

    User user = userService.byUserId(appeal.getAppealUserId());
    appealResp.setAppealUserName(user.getNickname());

    appealResp.setAppealFile(appeal.getAppealFile());
    appealResp.setCreateTime(appeal.getCreateTime());

    return appealResp;
  }

  @Override
  public Appeal findById(Long appealId) {
    return appealRepository.findById(appealId);
  }
}
