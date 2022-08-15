package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.InvitationCollectionLog;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvitationCollectionLogMapper extends BaseMapper<InvitationCollectionLog> {
  int updateBatchSelective(List<InvitationCollectionLog> list);

  int batchInsert(@Param("list") List<InvitationCollectionLog> list);
}
