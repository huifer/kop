package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.UserCategoryApply;
import com.github.kop.bbs.module.enums.category.UserCategoryApplyStatusEnum;
import com.github.kop.bbs.repo.UserCategoryApplyRepository;
import com.github.kop.bbs.repo.mapper.UserCategoryApplyMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

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
    validateByCategoryAndUser(userId);
    return userCategoryApplyMapper.insert(UserCategoryApply.builder()
        .categoryId(categoryId)
        .userId(userId)
        .status(UserCategoryApplyStatusEnum.PENDING_REVIEW.getCode())
        .build());
  }

  /**
   * 一个人只能申请一个版主
   */
  private void validateByCategoryAndUser(Long userId) {

    if (hasCategoryApply(userId)) {
      throw new RuntimeException("您已申请过其他版主，请勿重复申请");
    }
  }

  public boolean hasCategoryApply(Long userId) {
    QueryWrapper<UserCategoryApply> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda()
        .eq(UserCategoryApply::getUserId, userId);
    Long aLong = this.userCategoryApplyMapper.selectCount(queryWrapper);
    return aLong > 0;
  }

}
