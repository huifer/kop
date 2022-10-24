package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.VoteTicketCount;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:46
 */
public interface VoteTicketCountRepository {
  Long findCountByApplyId(Long applyId);

  int insert(VoteTicketCount build);

  /**
   * 投票
   *
   * @param applyId
   * @return
   */
  int addVoteTicket(Long applyId);

  List<VoteTicketCount> findTicketByApplyIds(List<Long> applyIdList);
}
