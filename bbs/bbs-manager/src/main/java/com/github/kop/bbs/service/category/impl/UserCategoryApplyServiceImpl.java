package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.UserCategoryApply;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.UserCategoryApplyRepository;
import com.github.kop.bbs.utils.UserInfoThread;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.github.kop.bbs.service.category.UserCategoryApplyService;

import javax.annotation.Resource;
import java.util.List;

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
    public Boolean applyCategory(Long categoryId) {
        if(ObjectUtils.isEmpty(categoryId)){
            throw new NoceException("版块内容不能为空!");
        }
        Long userId = UserInfoThread.getUserId();
        validateByCategoryAndUser(categoryId,userId);
        return userCategoryApplyRepository.applyCategory(userId,categoryId) > 1;
    }


    private void validateByCategoryAndUser(Long categoryId,Long userId){
        List<UserCategoryApply> list = userCategoryApplyRepository.getByCategoryIdAndUserId(userId,categoryId);
        if (ObjectUtils.isNotEmpty(list)){
            throw new NoceException("当前版块已经申请版主!");
        }
    }


}
