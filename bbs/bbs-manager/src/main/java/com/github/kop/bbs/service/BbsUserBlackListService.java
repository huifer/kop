package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsUserBlackList;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsUserBlackListService extends IService<BbsUserBlackList>{


    int updateBatchSelective(List<BbsUserBlackList> list);

    int batchInsert(List<BbsUserBlackList> list);

}
