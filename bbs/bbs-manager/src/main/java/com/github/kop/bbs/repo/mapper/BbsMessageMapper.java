package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsMessage;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsMessageMapper extends BaseMapper<BbsMessage> {
    int updateBatchSelective(List<BbsMessage> list);

    int batchInsert(@Param("list") List<BbsMessage> list);
}