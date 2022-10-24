package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.blob.module.entity.BlogCollection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogCollectionMapper extends BaseMapper<BlogCollection> {
  int updateBatchSelective(List<BlogCollection> list);

  int batchInsert(@Param("list") List<BlogCollection> list);
}
