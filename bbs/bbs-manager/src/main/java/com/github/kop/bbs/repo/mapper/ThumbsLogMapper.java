package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.ThumbsLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThumbsLogMapper extends BaseMapper<ThumbsLog> {
    int updateBatchSelective(List<ThumbsLog> list);

    int batchInsert(@Param("list") List<ThumbsLog> list);
}