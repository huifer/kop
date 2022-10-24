package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.VoteTicketCount;
import org.apache.ibatis.annotations.Param;

public interface VoteTicketCountMapper extends BaseMapper<VoteTicketCount> {

  /**
   * 投票
   *
   * @param applyId
   * @return
   */
  int addVoteTicket(@Param("applyId") Long applyId);
}
