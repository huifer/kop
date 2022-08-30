package com.github.kop.bbs.service.category;

import com.github.kop.bbs.module.entity.VoteTicketLog;

import java.util.List;

public interface VoteTicketLogService{


    int insert(VoteTicketLog build);

    Boolean checkByUserIdAndApplyIdList(List<Long> applyIdList, Long userId);
}
