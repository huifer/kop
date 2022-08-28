package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.MidUserCategoryVoteApplyRepository;
import com.github.kop.bbs.service.category.MidUserCategoryService;
import com.github.kop.bbs.service.category.UserCategoryVoteSettingService;
import com.github.kop.bbs.service.category.MidUserCategoryVoteService;
import com.github.kop.bbs.service.user.MidUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MidUserCategoryVoteServiceImpl implements MidUserCategoryVoteService {


    @Resource
    private MidUserCategoryVoteApplyRepository midUserCategoryVoteApplyRepository;

    @Resource
    private UserCategoryVoteSettingService userCategoryVoteSettingService;


    @Resource
    private MidUserRoleService midUserRoleService;


    /**
     * 根据voteId验证投票
     *
     * @param voteSettingId
     */
    @Override
    public Integer verifyByVoteId(Long voteSettingId,Long userId) {
        // 验证是否有身份
        boolean b = midUserRoleService.existsUserRole(userId, RoleEnum.WEBMASTER.getRoleCode());
        if(b){
            throw new NoceException("您已经是版主,无法申请");
        }
        // 验证投票设置
        UserCategoryVoteSetting userCategoryVoteSetting = userCategoryVoteSettingService.verifyByVoteId(voteSettingId);
        midUserCategoryVoteApplyRepository.verifyByUserId(userId);
        return midUserCategoryVoteApplyRepository.insert(MidUserCategoryVoteApply.builder()
                .voteSettingId(userCategoryVoteSetting.getVoteSettingId())
                .categoryId(userCategoryVoteSetting.getCategoryId())
                .userId(userId)
                .deleted(DeletedEnum.FALSE.getCode())
                .build());
    }


    @Override
    public boolean applyVote(Long voteSettingId, Long userId) {
        return verifyByVoteId(voteSettingId,userId)>0;
    }
}


















