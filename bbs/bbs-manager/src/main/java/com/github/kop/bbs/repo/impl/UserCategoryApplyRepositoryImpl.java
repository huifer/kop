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

    /**
     * 一个人只能申请一个版主
     * @param categoryId
     * @param userId
     */
    private void validateByCategoryAndUser(Long categoryId,Long userId){
        QueryWrapper<UserCategoryApply> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            .eq(UserCategoryApply::getUserId, userId);
        Long aLong = this.userCategoryApplyMapper.selectCount(queryWrapper);
        if (aLong > 0) {
            throw new RuntimeException("您已申请过其他版主，请勿重复申请");
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
