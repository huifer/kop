package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsThumbsLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsThumbsLogMapper extends BaseMapper<BbsThumbsLog> {
    int updateBatchSelective(List<BbsThumbsLog> list);

    int batchInsert(@Param("list") List<BbsThumbsLog> list);
}