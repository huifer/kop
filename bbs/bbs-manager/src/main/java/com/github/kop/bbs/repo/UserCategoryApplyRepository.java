package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.UserCategoryApply;

import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/17 21:24
 */
public interface UserCategoryApplyRepository {
    int applyCategory(Long userId, Long categoryId);

    List<UserCategoryApply> getByCategoryIdAndUserId(Long userId, Long categoryId);
}
