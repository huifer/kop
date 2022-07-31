package com.github.kop.blob.service;

import java.util.List;
import com.github.kop.blob.module.entity.BlogArticle;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogArticleService extends IService<BlogArticle> {


    int updateBatchSelective(List<BlogArticle> list);

    int batchInsert(List<BlogArticle> list);

}



