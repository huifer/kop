package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsCategoryMapper extends BaseMapper<BbsCategory> {
    int updateBatchSelective(List<BbsCategory> list);

    int batchInsert(@Param("list") List<BbsCategory> list);
}