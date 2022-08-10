package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsUserScore;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsUserScoreMapper extends BaseMapper<BbsUserScore> {
    int updateBatchSelective(List<BbsUserScore> list);

    int batchInsert(@Param("list") List<BbsUserScore> list);
}