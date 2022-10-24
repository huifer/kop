package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.blob.module.entity.BlogFocus;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogFocusMapper extends BaseMapper<BlogFocus> {
  int updateBatchSelective(List<BlogFocus> list);

  int batchInsert(@Param("list") List<BlogFocus> list);
}
