package com.github.kop.blob.service;

import java.util.List;
import com.github.kop.blob.module.entity.BlogCollection;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogCollectionService extends IService<BlogCollection> {


    int updateBatchSelective(List<BlogCollection> list);

    int batchInsert(List<BlogCollection> list);

}



