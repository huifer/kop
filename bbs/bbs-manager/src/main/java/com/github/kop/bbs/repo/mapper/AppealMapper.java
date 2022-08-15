package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Appeal;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppealMapper extends BaseMapper<Appeal> {
  int updateBatchSelective(List<Appeal> list);

  int batchInsert(@Param("list") List<Appeal> list);
}
