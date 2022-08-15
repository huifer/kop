package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Punishment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PunishmentMapper extends BaseMapper<Punishment> {
  int updateBatchSelective(List<Punishment> list);

  int batchInsert(@Param("list") List<Punishment> list);
}
