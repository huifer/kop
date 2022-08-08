package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsTopic;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsTopicMapper extends BaseMapper<BbsTopic> {
    int updateBatchSelective(List<BbsTopic> list);

    int batchInsert(@Param("list") List<BbsTopic> list);
}