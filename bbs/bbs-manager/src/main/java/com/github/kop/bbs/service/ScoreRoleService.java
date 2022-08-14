package com.github.kop.bbs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.score.CreateScoreRoleReq;
import com.github.kop.bbs.module.req.score.PageListScoreRoleReq;
import com.github.kop.bbs.module.req.score.UpdateScoreRoleReq;
import com.github.kop.bbs.module.res.score.ScorePageListRes;

public interface ScoreRoleService {


    Boolean create(CreateScoreRoleReq req);

    Boolean update(UpdateScoreRoleReq req);

    Boolean delete(Long id);

    IPage<ScorePageListRes> pageList(PageListScoreRoleReq pageListScoreRoleReq, Long page, Long size);
}


