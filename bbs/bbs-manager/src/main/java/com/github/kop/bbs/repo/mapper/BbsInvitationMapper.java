package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsInvitation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsInvitationMapper extends BaseMapper<BbsInvitation> {
    int updateBatchSelective(List<BbsInvitation> list);

    int batchInsert(@Param("list") List<BbsInvitation> list);
}