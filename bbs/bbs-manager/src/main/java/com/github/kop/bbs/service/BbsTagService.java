package com.github.kop.bbs.service;

import com.github.kop.bbs.module.entity.BbsTag;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsTagService extends IService<BbsTag>{


    int updateBatchSelective(List<BbsTag> list);

    int batchInsert(List<BbsTag> list);

}
