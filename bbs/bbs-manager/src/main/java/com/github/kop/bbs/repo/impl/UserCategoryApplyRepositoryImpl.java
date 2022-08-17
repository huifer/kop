package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.UserCategoryApply;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.enums.userCategoryApply.UserCategoryApplyStatus;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.UserCategoryApplyRepository;
import com.github.kop.bbs.repo.mapper.UserCategoryApplyMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/17 21:24
 */
@Repository
public class UserCategoryApplyRepositoryImpl implements UserCategoryApplyRepository {

    @Resource
    private UserCategoryApplyMapper userCategoryApplyMapper;

    @Override
    public int applyCategory(Long userId, Long categoryId) {
        validateByCategoryAndUser(categoryId,userId);
        return userCategoryApplyMapper.insert(UserCategoryApply.builder()
                        .categoryId(categoryId)
                        .userId(userId)
                        .status(UserCategoryApplyStatus.PENDING_REVIEW.getCode())
                .build());
    }

    private void validateByCategoryAndUser(Long categoryId,Long userId){
        List<UserCategoryApply> list = getByCategoryIdAndUserId(userId,categoryId);
        if (ObjectUtils.isNotEmpty(list)){
            throw new NoceException("当前版块已经申请版主!");
        }
    }

    @Override
    public List<UserCategoryApply> getByCategoryIdAndUserId(Long userId, Long categoryId) {
        QueryWrapper<UserCategoryApply> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserCategoryApply::getUserId,userId)
                .eq(UserCategoryApply::getCategoryId,categoryId)
                .eq(UserCategoryApply::getDeleted, DeletedEnum.FALSE.getCode());
        return userCategoryApplyMapper.selectList(queryWrapper);
    }
}
