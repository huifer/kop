package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsInvitationCollectionLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsInvitationCollectionLogMapper extends BaseMapper<BbsInvitationCollectionLog> {
    int updateBatchSelective(List<BbsInvitationCollectionLog> list);

    int batchInsert(@Param("list") List<BbsInvitationCollectionLog> list);
}