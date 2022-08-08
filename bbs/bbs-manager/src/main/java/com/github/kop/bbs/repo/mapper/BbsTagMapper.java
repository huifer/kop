package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsTag;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsTagMapper extends BaseMapper<BbsTag> {
    int updateBatchSelective(List<BbsTag> list);

    int batchInsert(@Param("list") List<BbsTag> list);
}