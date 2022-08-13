package com.github.kop.bbs.service.impl;

import com.github.kop.bbs.module.entity.MidUserCategory;
import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.midUserCategory.CreateMidUserCategoryReq;
import com.github.kop.bbs.module.req.user.CreateUserReq;
import com.github.kop.bbs.module.req.user.UpdateUserReq;
import com.github.kop.bbs.repo.MidUserCategoryRepository;
import com.github.kop.bbs.repo.MidUserRoleRepository;
import com.github.kop.bbs.service.MidUserCategoryService;
import com.github.kop.bbs.service.MidUserRoleService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 版主与分类的中间表 服务实现类
 * </p>
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Service
public class MidUserCategoryServiceImpl implements MidUserCategoryService {

    private final MidUserCategoryCreateAndUpdateValidate midUserCategoryCreateAndUpdateValidate =
            new MidUserCategoryCreateAndUpdateValidate();

    @Resource
    private MidUserCategoryRepository midUserCategoryRepository;

    @Resource
    private MidUserRoleService midUserRoleService;

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
        Boolean insert = midUserCategoryRepository.insert(MidUserCategory.builder()
                .userId(req.getUserId())
                .categoryId(req.getCategoryId())
                .deleted(DeletedEnum.FALSE.getCode())
                .build());
        if(!insert){
            throw new NoceException("添加版主失败!");
        }
        // 增加版主对应的角色
        MidUserRole role = MidUserRole.builder()
                .userId(req.getUserId())
                .roleId(RoleEnum.WEBMASTER.getRoleId())
                .roleCode(RoleEnum.WEBMASTER.getRoleCode())
                .deleted(DeletedEnum.FALSE.getCode())
                .build();
        boolean roleExist = midUserRoleService.existsUserRole(role);
        // 没有版主角色去添加
        if(!roleExist){
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
    public Boolean delete(Long id,Long userId) {
        if(null == id){
            throw new NoceException("id不能为空");
        }
        int count = midUserCategoryRepository.deleteById(id);
        if(count == 0){
            throw new NoceException("当前版主信息不存在或已经删除");
        }
        int size = midUserCategoryRepository.selectCountByUserId(userId);
        // 已经没有版主信息,移除版主角色
        if (size == 0) {
            // 再次查询
            midUserRoleService.deleteUserRole(MidUserRole.builder()
                    .userId(userId)
                    .roleId(RoleEnum.WEBMASTER.getRoleId())
                    .roleCode(RoleEnum.WEBMASTER.getRoleCode())
                    .deleted(DeletedEnum.TRUE.getCode())
                    .build());
        }
        return true;
    }

    protected class MidUserCategoryCreateAndUpdateValidate
            implements CreateValidate<CreateMidUserCategoryReq> {

        @Override
        public void createValidate(CreateMidUserCategoryReq createMidUserCategoryReq) throws ValidateException {
            boolean b = midUserCategoryRepository.existsUserIdAndCategory(createMidUserCategoryReq.getUserId(),createMidUserCategoryReq.getCategoryId());
            if (b){
                throw new NoceException("此用户已经是版主!");
            }
        }
    }
}
