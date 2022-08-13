package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.ScoreLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreLogMapper extends BaseMapper<ScoreLog> {
    int updateBatchSelective(List<ScoreLog> list);

    int batchInsert(@Param("list") List<ScoreLog> list);
}