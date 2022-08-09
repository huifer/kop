package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsTopic;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsTopicService extends IService<BbsTopic>{


    int updateBatchSelective(List<BbsTopic> list);

    int batchInsert(List<BbsTopic> list);

}
