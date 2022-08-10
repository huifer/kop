package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsThumbsLog;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsThumbsLogService extends IService<BbsThumbsLog> {


    int updateBatchSelective(List<BbsThumbsLog> list);

    int batchInsert(List<BbsThumbsLog> list);

}


