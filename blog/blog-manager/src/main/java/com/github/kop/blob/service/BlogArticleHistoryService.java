package com.github.kop.blob.service;

import com.github.kop.blob.module.entity.BlogArticleHistory;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogArticleHistoryService extends IService<BlogArticleHistory> {


    int updateBatchSelective(List<BlogArticleHistory> list);

    int batchInsert(List<BlogArticleHistory> list);

}



