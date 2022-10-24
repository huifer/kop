package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MidUserCategoryVoteApplyMapper extends BaseMapper<MidUserCategoryVoteApply> {
  List<MidUserCategoryVoteApply> findEfficient(@Param("userId") Long userId);
}
