package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.blob.module.entity.BlogArticle;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogArticleMapper extends BaseMapper<BlogArticle> {
    int updateBatchSelective(List<BlogArticle> list);

    int batchInsert(@Param("list") List<BlogArticle> list);
}