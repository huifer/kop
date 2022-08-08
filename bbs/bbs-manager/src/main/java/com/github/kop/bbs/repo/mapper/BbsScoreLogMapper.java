package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsScoreLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsScoreLogMapper extends BaseMapper<BbsScoreLog> {
    int updateBatchSelective(List<BbsScoreLog> list);

    int batchInsert(@Param("list") List<BbsScoreLog> list);
}