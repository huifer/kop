package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsAppeal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsAppealMapper extends BaseMapper<BbsAppeal> {
    int updateBatchSelective(List<BbsAppeal> list);

    int batchInsert(@Param("list") List<BbsAppeal> list);
}