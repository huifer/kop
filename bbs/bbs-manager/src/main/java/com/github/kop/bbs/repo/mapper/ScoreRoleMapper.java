package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.ScoreRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScoreRoleMapper extends BaseMapper<ScoreRole> {
    int updateBatchSelective(List<ScoreRole> list);

    int batchInsert(@Param("list") List<ScoreRole> list);
}