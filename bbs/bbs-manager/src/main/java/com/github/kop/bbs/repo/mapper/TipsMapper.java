package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Tips;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TipsMapper extends BaseMapper<Tips> {
    int updateBatchSelective(List<Tips> list);

    int batchInsert(@Param("list") List<Tips> list);
}