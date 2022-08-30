package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import org.apache.ibatis.annotations.Param;

public interface MidUserCategoryVoteMapper extends BaseMapper<UserCategoryVoteSetting> {
    UserCategoryVoteSetting findStartSetting(@Param("categoryId") Long categoryId);
}