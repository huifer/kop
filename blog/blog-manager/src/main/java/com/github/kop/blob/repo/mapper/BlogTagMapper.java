package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.blob.module.entity.BlogTag;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogTagMapper extends BaseMapper<BlogTag> {
  int updateBatchSelective(List<BlogTag> list);

  int batchInsert(@Param("list") List<BlogTag> list);

  Page<BlogTag> listByUserId(Page<BlogTag> page, @Param("userId") Long userId);
}
