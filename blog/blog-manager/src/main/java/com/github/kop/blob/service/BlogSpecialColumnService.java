package com.github.kop.blob.service;

import com.github.kop.blob.module.entity.BlogSpecialColumn;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogSpecialColumnService extends IService<BlogSpecialColumn> {


    int updateBatchSelective(List<BlogSpecialColumn> list);

    int batchInsert(List<BlogSpecialColumn> list);

}



