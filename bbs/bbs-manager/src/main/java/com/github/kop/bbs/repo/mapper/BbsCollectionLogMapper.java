package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsCollectionLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsCollectionLogMapper extends BaseMapper<BbsCollectionLog> {
    int updateBatchSelective(List<BbsCollectionLog> list);

    int batchInsert(@Param("list") List<BbsCollectionLog> list);
}