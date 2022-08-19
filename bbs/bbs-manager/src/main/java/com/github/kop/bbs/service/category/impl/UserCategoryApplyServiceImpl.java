package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.UserCategoryApplyRepository;
import com.github.kop.bbs.service.category.UserCategoryApplyService;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class UserCategoryApplyServiceImpl implements UserCategoryApplyService {

  @Resource
  private UserCategoryApplyRepository userCategoryApplyRepository;


  /**
   * 申请版主
   *
   * @param categoryId
   * @return
   */
  @Override
  public boolean applyCategory(Long categoryId, Long userId) {
    if (ObjectUtils.isEmpty(categoryId)) {
      throw new NoceException("版块内容不能为空!");
    }

    if (userCategoryApplyRepository.hasCategoryApply(userId)) {
      throw new RuntimeException("您已申请过其他版主，请勿重复申请");
    }
    return userCategoryApplyRepository.applyCategory(userId, categoryId) > 1;
  }


}
