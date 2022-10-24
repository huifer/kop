package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.VoteTicketLog;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.repo.VoteTicketLogRepository;
import com.github.kop.bbs.repo.mapper.VoteTicketLogMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/28 21:47
 */
@Repository
public class VoteTicketLogRepositoryImpl implements VoteTicketLogRepository {

  @Resource private VoteTicketLogMapper voteTicketLogMapper;

  @Override
  public int insert(VoteTicketLog build) {
    return voteTicketLogMapper.insert(build);
  }

  @Override
  public List<VoteTicketLog> findByUserIdAndApplyIdList(List<Long> applyIdList, Long userId) {
    QueryWrapper<VoteTicketLog> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .in(VoteTicketLog::getApplyId, applyIdList)
        .eq(VoteTicketLog::getUserId, userId)
        .eq(VoteTicketLog::getDeleted, DeletedEnum.FALSE.getCode());
    return voteTicketLogMapper.selectList(queryWrapper);
  }
}
