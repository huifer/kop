package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsScoreRole;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsScoreRoleMapper extends BaseMapper<BbsScoreRole> {
    int updateBatchSelective(List<BbsScoreRole> list);

    int batchInsert(@Param("list") List<BbsScoreRole> list);
}