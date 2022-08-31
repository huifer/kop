package com.github.kop.bbs.service.category;


import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;

public interface UserCategoryVoteSettingService {


    UserCategoryVoteSetting verifyByVoteId(Long voteSettingId);

    void verifyTicketTime(Long voteSettingId);

    UserCategoryVoteSetting findStartSetting(Long categoryId);
}


