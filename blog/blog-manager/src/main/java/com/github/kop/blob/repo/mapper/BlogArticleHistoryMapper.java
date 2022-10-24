package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.blob.module.entity.BlogArticleHistory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogArticleHistoryMapper extends BaseMapper<BlogArticleHistory> {
  int updateBatchSelective(List<BlogArticleHistory> list);

  int batchInsert(@Param("list") List<BlogArticleHistory> list);
}
