package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.MidUserCategoryVoteApplyRepository;
import com.github.kop.bbs.repo.mapper.MidUserCategoryVoteApplyMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/22 23:39
 */
@Repository
public class MidUserCategoryVoteApplyRepositoryImpl implements MidUserCategoryVoteApplyRepository {

  @Resource private MidUserCategoryVoteApplyMapper midUserCategoryVoteApplyMapper;

  @Override
  public void verifyByUserId(Long userId) {
    if (findEfficient(userId).size() > 0) {
      throw new NoceException("已经申请其他或申请已提交");
    }
  }

  /**
   * 根据用户获取投票结束时间内的申请
   *
   * @param userId
   * @return
   */
  private List<MidUserCategoryVoteApply> findEfficient(Long userId) {
    return midUserCategoryVoteApplyMapper.findEfficient(userId);
  }

  @Override
  public int insert(MidUserCategoryVoteApply build) {
    verifyByUserId(build.getUserId());
    return midUserCategoryVoteApplyMapper.insert(build);
  }

  @Override
  public MidUserCategoryVoteApply findByApplyId(Long applyId) {
    QueryWrapper<MidUserCategoryVoteApply> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(MidUserCategoryVoteApply::getApplyId, applyId)
        .eq(MidUserCategoryVoteApply::getDeleted, DeletedEnum.FALSE.getCode());
    return midUserCategoryVoteApplyMapper.selectOne(queryWrapper);
  }

  @Override
  public List<MidUserCategoryVoteApply> findByVoteSettingId(Long voteSettingId) {
    QueryWrapper<MidUserCategoryVoteApply> queryWrapper = new QueryWrapper<>();
    queryWrapper
        .lambda()
        .eq(MidUserCategoryVoteApply::getVoteSettingId, voteSettingId)
        .eq(MidUserCategoryVoteApply::getDeleted, DeletedEnum.FALSE.getCode());
    return midUserCategoryVoteApplyMapper.selectList(queryWrapper);
  }
}
