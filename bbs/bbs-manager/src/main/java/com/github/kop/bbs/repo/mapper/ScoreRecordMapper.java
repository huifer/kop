package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.ScoreRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreRecordMapper extends BaseMapper<ScoreRecord> {
    int updateBatchSelective(List<ScoreRecord> list);

    int batchInsert(@Param("list") List<ScoreRecord> list);
}