package com.github.kop.blob.service;

import java.util.List;
import com.github.kop.blob.module.entity.BlogCategory;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogCategoryService extends IService<BlogCategory> {


    int updateBatchSelective(List<BlogCategory> list);

    int batchInsert(List<BlogCategory> list);

}



