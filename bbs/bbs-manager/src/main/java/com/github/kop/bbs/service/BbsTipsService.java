package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsTips;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsTipsService extends IService<BbsTips> {


    int updateBatchSelective(List<BbsTips> list);

    int batchInsert(List<BbsTips> list);

}


