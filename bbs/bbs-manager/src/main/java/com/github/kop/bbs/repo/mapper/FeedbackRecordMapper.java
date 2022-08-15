package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.FeedbackRecord;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FeedbackRecordMapper extends BaseMapper<FeedbackRecord> {
  int updateBatchSelective(List<FeedbackRecord> list);

  int batchInsert(@Param("list") List<FeedbackRecord> list);
}
