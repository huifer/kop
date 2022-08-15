package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.MidUserCategory;
import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.entity.Role;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.midUserCategory.CreateMidUserCategoryReq;
import com.github.kop.bbs.repo.MidUserCategoryRepository;
import com.github.kop.bbs.service.category.MidUserCategoryService;
import com.github.kop.bbs.service.role.RoleService;
import com.github.kop.bbs.service.user.MidUserRoleService;
import com.github.kop.bbs.utils.CreateValidate;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 版主与分类的中间表 服务实现类
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Service
public class MidUserCategoryServiceImpl implements MidUserCategoryService {

  private final MidUserCategoryCreateAndUpdateValidate midUserCategoryCreateAndUpdateValidate =
      new MidUserCategoryCreateAndUpdateValidate();

  @Resource private MidUserCategoryRepository midUserCategoryRepository;

  @Resource private MidUserRoleService midUserRoleService;

  /**
   * 添加版主
   *
   * @param req
   * @return
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean create(CreateMidUserCategoryReq req) {
    midUserCategoryCreateAndUpdateValidate.createValidate(req);
    Boolean insert =
        midUserCategoryRepository.insert(
            MidUserCategory.builder()
                .userId(req.getUserId())
                .categoryId(req.getCategoryId())
                .deleted(DeletedEnum.FALSE.getCode())
                .build());
    if (!insert) {
      throw new NoceException("添加版主失败!");
    }
    // 增加版主对应的角色
    MidUserRole role =
        MidUserRole.builder()
            .userId(req.getUserId())
            .roleId(RoleEnum.WEBMASTER.getRoleId())
            .roleCode(RoleEnum.WEBMASTER.getRoleCode())
            .deleted(DeletedEnum.FALSE.getCode())
            .build();
    boolean roleExist =
        midUserRoleService.existsUserRole(req.getUserId(), RoleEnum.WEBMASTER.getRoleCode());
    // 没有版主角色去添加
    if (!roleExist) {
      midUserRoleService.addUserRole(role);
    }
    return true;
  }

  /**
   * 移除版主
   *
   * @param id
   * @return
   */
  @Override
  public Boolean delete(Long id, Long userId) {
    if (null == id) {
      throw new NoceException("id不能为空");
    }
    int count = midUserCategoryRepository.deleteById(id);
    if (count == 0) {
      throw new NoceException("当前版主信息不存在或已经删除");
    }
    int size = midUserCategoryRepository.selectCountByUserId(userId);
    // 已经没有版主信息,移除版主角色
    if (size == 0) {

      Role role = roleService.byCode(RoleEnum.WEBMASTER.getRoleCode());
      // 再次查询
      return midUserRoleService.deleteUserRole(userId, role.getRoleId());
    }
    return true;
  }

  @Autowired private RoleService roleService;

  protected class MidUserCategoryCreateAndUpdateValidate
      implements CreateValidate<CreateMidUserCategoryReq> {

    @Override
    public void createValidate(CreateMidUserCategoryReq createMidUserCategoryReq)
        throws ValidateException {
      boolean b =
          midUserCategoryRepository.existsUserIdAndCategory(
              createMidUserCategoryReq.getUserId(), createMidUserCategoryReq.getCategoryId());
      if (b) {
        throw new NoceException("此用户已经是版主!");
      }
    }
  }
}
