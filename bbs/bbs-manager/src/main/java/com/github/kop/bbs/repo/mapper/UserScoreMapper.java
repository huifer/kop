package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.UserScore;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserScoreMapper extends BaseMapper<UserScore> {
  int updateBatchSelective(List<UserScore> list);

  int batchInsert(@Param("list") List<UserScore> list);
}
