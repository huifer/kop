package com.github.kop.blob.service;

import java.util.List;
import com.github.kop.blob.module.entity.BlogFocus;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogFocusService extends IService<BlogFocus> {


    int updateBatchSelective(List<BlogFocus> list);

    int batchInsert(List<BlogFocus> list);

}



