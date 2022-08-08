package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsInvitationThumbsLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsInvitationThumbsLogMapper extends BaseMapper<BbsInvitationThumbsLog> {
    int updateBatchSelective(List<BbsInvitationThumbsLog> list);

    int batchInsert(@Param("list") List<BbsInvitationThumbsLog> list);
}