package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.CollectionLog;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CollectionLogMapper extends BaseMapper<CollectionLog> {
    int updateBatchSelective(List<CollectionLog> list);

    int batchInsert(@Param("list") List<CollectionLog> list);
}