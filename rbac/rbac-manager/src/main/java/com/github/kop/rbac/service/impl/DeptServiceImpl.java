package com.github.kop.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.entity.RbacDept;
import com.github.kop.rbac.module.enums.AppHttpCodeEnum;
import com.github.kop.rbac.module.ex.ValidateException;
import com.github.kop.rbac.module.req.dept.CreateDeptReq;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import com.github.kop.rbac.module.req.dept.UpdateDeptReq;
import com.github.kop.rbac.module.res.dept.DeptQueryRes;
import com.github.kop.rbac.repo.DeptRepository;
import com.github.kop.rbac.service.DeptService;
import com.github.kop.rbac.utils.CreateValidate;
import com.github.kop.rbac.utils.UpdateValidate;
import com.github.kop.rbac.utils.UserInfoThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
  protected final DeptCreateAndUpdateValidate validate = new DeptCreateAndUpdateValidate();
  @Autowired private DeptRepository deptRepository;

  @Override
  public List<DeptQueryRes> tree(Long companyId, Long deptId) {
    if (companyId != null && deptId != null) {
      throw new ValidateException("树结构查询只允许部门id或者企业id查询，不允许同时查询");
    }
    if (companyId != null) {
      List<RbacDept> rbacDepts = deptRepository.findByCompanyId(companyId);
      return tree(rbacDepts);
    } else if (deptId != null) {
      List<RbacDept> rbacDepts = deptRepository.findByDeptIdForChild(deptId);
      return tree(rbacDepts);
    }
    return new ArrayList<>();
  }

  @NotNull
  private List<DeptQueryRes> tree(List<RbacDept> rbacDepts) {
    List<DeptQueryRes> list = new ArrayList<>();
    Map<Long, List<RbacDept>> collect =
        rbacDepts.stream().collect(Collectors.groupingBy(RbacDept::getPid));
    for (RbacDept rbacDept : rbacDepts) {
      DeptQueryRes conv = conv(rbacDept, false);
      List<RbacDept> rbacDepts1 = collect.get(conv.getId());
      List<DeptQueryRes> child = new ArrayList<>();
      for (RbacDept dept : rbacDepts1) {
        child.add(conv(dept, false));
      }
      conv.setChild(child);
      list.add(conv);
    }

    return list;
  }

  @Override
  public List<DeptQueryRes> list(QueryDeptReq req) {
    List<RbacDept> list = deptRepository.list(req);
    List<DeptQueryRes> res = new ArrayList<>();
    for (RbacDept rbacDept : list) {
      res.add(conv(rbacDept, false));
    }
    return res;
  }

  @Override
  public DeptQueryRes byId(Long id) {
    RbacDept rbacDept = deptRepository.byId(id);

    Long companyId = UserInfoThread.getCompanyId();

    if (!companyId.equals(rbacDept.getCompanyId())) {
      throw new ValidateException("当前用户所在企业和操作部门所在企业并非同一个");
    }

    return conv(rbacDept, true);
  }

  private DeptQueryRes conv(RbacDept rbacDept, boolean fillParent) {
    DeptQueryRes deptQueryRes = new DeptQueryRes();
    deptQueryRes.setId(rbacDept.getId());
    deptQueryRes.setName(rbacDept.getName());
    deptQueryRes.setDesc(rbacDept.getDesc());
    deptQueryRes.setSort(rbacDept.getSort());
    if (fillParent) {
      if (rbacDept.getPid() != null) {
        deptQueryRes.setPid(rbacDept.getPid());
        RbacDept rbacDept1 = deptRepository.byId(rbacDept.getPid());
        if (rbacDept1 != null) {
          deptQueryRes.setPName(rbacDept1.getName());
        }
      }
    }

    return deptQueryRes;
  }

  @Override
  public int update(UpdateDeptReq req) {
    validate.updateValidate(req);
    RbacDept rbacDept = this.deptRepository.byId(req.getId());
    if (rbacDept != null) {

      Long companyId = UserInfoThread.getCompanyId();
      if (!companyId.equals(rbacDept.getCompanyId())) {
        throw new ValidateException("当前用户所在企业和操作部门所在企业并非同一个");
      }

      if (!StringUtils.isEmpty(req.getName())) {
        rbacDept.setName(req.getName());
      }

      if (!StringUtils.isEmpty(req.getDesc())) {
        rbacDept.setDesc(req.getDesc());
      }

      if (req.getPid() != null) {
        rbacDept.setPid(req.getPid());
      }

      if (req.getSort() != null) {
        rbacDept.setSort(req.getSort());
      }

      return deptRepository.update(rbacDept);
    }
    return -1;
  }

  @Override
  public int deleteById(Long id) {
    RbacDept rbacDept = deptRepository.byId(id);

    Long companyId = UserInfoThread.getCompanyId();

    if (!companyId.equals(rbacDept.getCompanyId())) {
      throw new ValidateException("当前用户所在企业和操作部门所在企业并非同一个");
    }

    return deptRepository.deleteById(id);
  }

  @Override
  public int create(CreateDeptReq req) {
    validate.createValidate(req);

    RbacDept rbacDept = new RbacDept();
    rbacDept.setName(req.getName());
    rbacDept.setDesc(req.getDesc());
    rbacDept.setSort(req.getSort());
    rbacDept.setPid(req.getPid());
    rbacDept.setCompanyId(UserInfoThread.getCompanyId());

    return deptRepository.create(rbacDept);
  }

  @Override
  public IPage<DeptQueryRes> page(Long page, Long size, QueryDeptReq req) {
    IPage<RbacDept> ipage = deptRepository.page(page, size, req);
    return ipage.convert(rbacDept -> conv(rbacDept, true));
  }

  protected static final class DeptCreateAndUpdateValidate
      implements CreateValidate<CreateDeptReq>, UpdateValidate<UpdateDeptReq> {
    @Override
    public void createValidate(CreateDeptReq req) throws ValidateException {
      String name = req.getName();
      if (StringUtils.isEmpty(name)) {
        throw new ValidateException("部门名称必填");
      }
    }

    @Override
    public void updateValidate(UpdateDeptReq req) throws ValidateException {
      Long id = req.getId();
      if (id == null) {
        throw new ValidateException(AppHttpCodeEnum.UPDATE_ID_ERROR);
      }
      String name = req.getName();
      if (StringUtils.isEmpty(name)) {
        throw new ValidateException("部门名称必填");
      }
    }
  }
}
