package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsFeedbackRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsFeedbackRecordMapper extends BaseMapper<BbsFeedbackRecord> {
    int updateBatchSelective(List<BbsFeedbackRecord> list);

    int batchInsert(@Param("list") List<BbsFeedbackRecord> list);
}