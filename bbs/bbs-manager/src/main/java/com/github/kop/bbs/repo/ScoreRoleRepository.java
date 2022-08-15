package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.ScoreRole;
import com.github.kop.bbs.module.req.score.PageListScoreRoleReq;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/14 15:31
 */
public interface ScoreRoleRepository {

  int insert(ScoreRole build);

  int update(ScoreRole scoreCycle);

  int delete(Long id);

  IPage<ScoreRole> pageList(Page<ScoreRole> objectPage, PageListScoreRoleReq pageListScoreRoleReq);

  ScoreRole findByType(int type);
}
