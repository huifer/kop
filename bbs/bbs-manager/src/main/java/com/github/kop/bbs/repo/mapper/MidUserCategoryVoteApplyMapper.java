package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MidUserCategoryVoteApplyMapper extends BaseMapper<MidUserCategoryVoteApply> {
    List<MidUserCategoryVoteApply> findEfficient(@Param("userId") Long userId);
}