package com.github.kop.bbs.service.category;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import com.github.kop.bbs.module.req.category.UserCategoryVoteSettingReq;
import com.github.kop.bbs.module.req.category.voteSettingListReq;
import com.github.kop.bbs.module.res.category.customer.CustomerUserCategoryVoteSettingRes;
import com.github.kop.bbs.module.res.category.manager.VoteSettingListRes;

public interface UserCategoryVoteSettingService {


    UserCategoryVoteSetting verifyByVoteId(Long voteSettingId);

    void verifyTicketTime(Long voteSettingId);

    UserCategoryVoteSetting findVoteStartSetting(Long categoryId);

    UserCategoryVoteSetting findApplyStartSetting(Long categoryId);

    /**
     * 创建版主投票
     * @param req
     * @return
     */
    Boolean create(UserCategoryVoteSettingReq req);

    /**
     * 获取申请中的的投票设置
     * @param categoryId
     * @return
     */
    CustomerUserCategoryVoteSettingRes getApplyStartSetting(Long categoryId);

    void updateApplyCount(Long voteSettingId);

    IPage<VoteSettingListRes> voteSettingList(voteSettingListReq req, Integer page, Integer pageSize);
}



