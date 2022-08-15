package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacApp;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.app.CreateAppReq;
import com.github.kop.rbac.module.req.app.QueryAppReq;
import com.github.kop.rbac.module.req.app.UpdateAppReq;
import com.github.kop.rbac.module.res.app.AppQueryRes;
import com.github.kop.rbac.repo.AppRepository;
import com.github.kop.rbac.service.AppService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
  protected AppValidate validate = new AppValidate();
  @Autowired private AppRepository appRepository;

  @Override
  public int create(CreateAppReq req) {
    validate.createValidate(req);
    RbacApp rbacApp = new RbacApp();
    rbacApp.setName(req.getName());
    rbacApp.setCode(req.getCode());

    return appRepository.create(rbacApp);
  }

  @Override
  public int update(UpdateAppReq req) {
    validate.updateValidate(req);

    RbacApp rbacApp = appRepository.byId(req.getId());
    if (rbacApp != null) {
      if (!StringUtils.isEmpty(req.getName())) {
        rbacApp.setName(req.getName());
      }
      return appRepository.update(rbacApp);
    }
    return -1;
  }

  @Override
  public AppQueryRes byId(Long id) {
    RbacApp rbacApp = appRepository.byId(id);
    if (rbacApp != null) {
      return conv(rbacApp);
    }
    return null;
  }

  private AppQueryRes conv(RbacApp rbacApp) {
    AppQueryRes appQueryRes = new AppQueryRes();
    appQueryRes.setId(rbacApp.getId());
    appQueryRes.setName(rbacApp.getName());
    appQueryRes.setCode(rbacApp.getCode());

    return appQueryRes;
  }

  @Override
  public int deleteById(Long id) {
    return this.appRepository.delete(id);
  }

  @Override
  public IPage<AppQueryRes> page(Long page, Long size, QueryAppReq req) {
    IPage<RbacApp> list = this.appRepository.page(page, size, req);

    return list.convert(this::conv);
  }

  @Override
  public List<AppQueryRes> list(QueryAppReq req) {
    List<RbacApp> list = this.appRepository.list(req);
    List<AppQueryRes> res = new ArrayList<>();
    for (RbacApp rbacApp : list) {
      res.add(conv(rbacApp));
    }
    return res;
  }

  protected class AppValidate
      implements CreateValidate<CreateAppReq>, UpdateValidate<UpdateAppReq> {

    @Override
    public void createValidate(CreateAppReq createAppReq) throws ValidateException {
      String name = createAppReq.getName();
      if (StringUtils.isEmpty(name)) {
        throw new ValidateException("应用名称必填");
      }
      String code = createAppReq.getCode();
      if (StringUtils.isEmpty(code)) {
        throw new ValidateException("应用编码必填");
      }
      boolean has = appRepository.hasCode(code);
      if (has) {
        throw new ValidateException("当前应用编码已存在");
      }
    }

    @Override
    public void updateValidate(UpdateAppReq updateAppReq) throws ValidateException {
      idValidate(updateAppReq.getId());
      String name = updateAppReq.getName();
      if (StringUtils.isEmpty(name)) {
        throw new ValidateException("应用名称必填");
      }
    }
  }
}
