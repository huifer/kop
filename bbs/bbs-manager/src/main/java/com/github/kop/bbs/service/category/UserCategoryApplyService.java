package com.github.kop.bbs.service.category;

public interface UserCategoryApplyService {

    /**
     * 申请版主
     * @param categoryId 板块id
     * @return
     */
    boolean  applyCategory(Long categoryId,Long userId);
}
