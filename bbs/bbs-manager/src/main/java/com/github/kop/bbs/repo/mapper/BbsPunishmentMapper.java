package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsPunishment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsPunishmentMapper extends BaseMapper<BbsPunishment> {
    int updateBatchSelective(List<BbsPunishment> list);

    int batchInsert(@Param("list") List<BbsPunishment> list);
}