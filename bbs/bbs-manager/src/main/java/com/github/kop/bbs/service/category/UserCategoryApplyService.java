package com.github.kop.bbs.service.category;

public interface UserCategoryApplyService {

    /**
     * 申请版主
     * @param categoryId
     * @return
     */
    Boolean applyCategory(Long categoryId);
}
