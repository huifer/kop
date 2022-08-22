package com.github.kop.bbs.service.appeal.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Appeal;
import com.github.kop.bbs.module.entity.User;
import com.github.kop.bbs.module.enums.AppealTypeEnum;
import com.github.kop.bbs.module.req.appeal.CreateAppealReq;
import com.github.kop.bbs.module.res.AppealResp;
import com.github.kop.bbs.repo.AppealRepository;
import com.github.kop.bbs.service.appeal.AppealService;
import com.github.kop.bbs.service.user.UserService;
import com.github.kop.bbs.utils.UserInfoThread;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppealServiceImpl implements AppealService {

  @Autowired
  private AppealRepository appealRepository;

  @Override
  public boolean create(CreateAppealReq req) {
    Appeal appeal = new Appeal();
    appeal.setAppealType(req.getAppealType());
    appeal.setAppealTitle(req.getAppealTitle());
    appeal.setAppealText(req.getAppealText());
    appeal.setAppealFile(req.getAppealFile());
    appeal.setAppealUserId(UserInfoThread.getUserId());
    return appealRepository.create(appeal) > 0;
  }

  @Override
  public IPage<AppealResp> page(Long page, Long size) {
    IPage<Appeal> pageRes = this.appealRepository.page(page, size);
    return pageRes.convert(new Function<Appeal, AppealResp>() {
      @Override
      public AppealResp apply(Appeal appeal) {
        AppealResp appealResp = new AppealResp();
        appealResp.setAppealType(appeal.getAppealType());
        appealResp.setAppealTypeString(AppealTypeEnum.conv(appeal.getAppealType()).getDesc());
        appealResp.setAppealTitle(appeal.getAppealTitle());
        appealResp.setAppealText(appeal.getAppealText());
        appealResp.setAppealUserId(appeal.getAppealUserId());

        User user = userService.byUserId(appeal.getAppealUserId());
        appealResp.setAppealUserName(user.getNickname());

        appealResp.setAppealFile(appeal.getAppealFile());
        appealResp.setCreateTime(appeal.getCreateTime());

        return appealResp;
      }
    });
  }

  @Autowired
  private UserService userService;
}
