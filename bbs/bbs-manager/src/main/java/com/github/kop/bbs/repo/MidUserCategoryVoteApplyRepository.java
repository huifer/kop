package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import java.util.List;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/22 23:39
 */
public interface MidUserCategoryVoteApplyRepository {
  void verifyByUserId(Long userId);

  int insert(MidUserCategoryVoteApply build);

  MidUserCategoryVoteApply findByApplyId(Long applyId);

  List<MidUserCategoryVoteApply> findByVoteSettingId(Long voteSettingId);
}
