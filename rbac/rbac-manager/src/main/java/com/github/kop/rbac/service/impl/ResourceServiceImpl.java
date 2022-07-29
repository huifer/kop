package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacResource;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.resource.CreateResourceReq;
import com.github.kop.rbac.module.req.resource.QueryResourceReq;
import com.github.kop.rbac.module.req.resource.UpdateResourceReq;
import com.github.kop.rbac.module.res.resource.ResourceQueryRes;
import com.github.kop.rbac.repo.ResourceRepository;
import com.github.kop.rbac.service.ResourceService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
  protected final ResourceCreateAndUpdateValidate resourceCreateAndUpdateValidate =
          new ResourceCreateAndUpdateValidate();
  @Autowired
  private ResourceRepository resourceRepository;

  @Override
  public int create(CreateResourceReq req) {
    this.resourceCreateAndUpdateValidate.createValidate(req);

    RbacResource rbacResource = new RbacResource();
    rbacResource.setCode(req.getCode());
    rbacResource.setName(req.getName());
    rbacResource.setType(req.getType());

    return this.resourceRepository.create(rbacResource);
  }

  @Override
  public int update(UpdateResourceReq req) {
    RbacResource rbacResource = this.resourceRepository.byId(req.getId());
    if (rbacResource != null) {
      if (req.getCode() != null) {
        rbacResource.setCode(req.getCode());
      }
      if (!StringUtils.isEmpty(req.getName())) {
        rbacResource.setName(req.getName());
      }
      if (!StringUtils.isEmpty(req.getType())) {
        rbacResource.setType(req.getType());
      }

      return this.resourceRepository.update(rbacResource);
    }
    return -1;
  }

  @Override
  public ResourceQueryRes byId(Long id) {
    RbacResource rbacResource = this.resourceRepository.byId(id);
    return conv(rbacResource);
  }

  private ResourceQueryRes conv(RbacResource rbacResource) {
    ResourceQueryRes resourceQueryRes = new ResourceQueryRes();
    resourceQueryRes.setId(rbacResource.getId());
    resourceQueryRes.setCode(rbacResource.getCode());
    resourceQueryRes.setName(rbacResource.getName());
    resourceQueryRes.setType(rbacResource.getType());
    return resourceQueryRes;
  }

  @Override
  public int deleteById(Long id) {
    return this.resourceRepository.deleteById(id);
  }

  @Override
  public IPage<ResourceQueryRes> page(Long page, Long size, QueryResourceReq req) {
    IPage<RbacResource> iPage = this.resourceRepository.page(page, size, req);
    return iPage.convert(this::conv);
  }

  @Override
  public List<ResourceQueryRes> list(QueryResourceReq req) {
    List<RbacResource> list = this.resourceRepository.list(req);
    List<ResourceQueryRes> res = new ArrayList<>(list.size());

    for (RbacResource rbacResource : list) {
      res.add(conv(rbacResource));
    }
    return res;
  }

  protected class ResourceCreateAndUpdateValidate
          implements CreateValidate<CreateResourceReq>, UpdateValidate<UpdateResourceReq> {
    @Override
    public void createValidate(CreateResourceReq createResourceReq) throws ValidateException {
    }

    @Override
    public void updateValidate(UpdateResourceReq updateResourceReq) throws ValidateException {
    }
  }
}
