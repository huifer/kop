package com.github.kop.bbs.repo;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/17 21:24
 */
public interface UserCategoryApplyRepository {

  int applyCategory(Long userId, Long categoryId);

  boolean hasCategoryApply(Long userId);

}
