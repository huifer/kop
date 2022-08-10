package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsUserFollowerList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsUserFollowerListMapper extends BaseMapper<BbsUserFollowerList> {
    int updateBatchSelective(List<BbsUserFollowerList> list);

    int batchInsert(@Param("list") List<BbsUserFollowerList> list);
}