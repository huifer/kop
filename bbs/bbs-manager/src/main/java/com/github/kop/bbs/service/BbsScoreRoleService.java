package com.github.kop.bbs.service;

import com.github.kop.bbs.module.entity.BbsScoreRole;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsScoreRoleService extends IService<BbsScoreRole>{


    int updateBatchSelective(List<BbsScoreRole> list);

    int batchInsert(List<BbsScoreRole> list);

}
