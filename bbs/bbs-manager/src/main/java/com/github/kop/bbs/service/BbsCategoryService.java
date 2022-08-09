package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsCategory;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsCategoryService extends IService<BbsCategory> {


    int updateBatchSelective(List<BbsCategory> list);

    int batchInsert(List<BbsCategory> list);

}


