package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsTips;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsTipsMapper extends BaseMapper<BbsTips> {
    int updateBatchSelective(List<BbsTips> list);

    int batchInsert(@Param("list") List<BbsTips> list);
}