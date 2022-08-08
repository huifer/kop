package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsScoreRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsScoreRecordMapper extends BaseMapper<BbsScoreRecord> {
    int updateBatchSelective(List<BbsScoreRecord> list);

    int batchInsert(@Param("list") List<BbsScoreRecord> list);
}