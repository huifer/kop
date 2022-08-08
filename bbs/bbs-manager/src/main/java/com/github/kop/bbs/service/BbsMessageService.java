package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsMessage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsMessageService extends IService<BbsMessage>{


    int updateBatchSelective(List<BbsMessage> list);

    int batchInsert(List<BbsMessage> list);

}
