package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.InvitationThumbsLog;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvitationThumbsLogMapper extends BaseMapper<InvitationThumbsLog> {
  int updateBatchSelective(List<InvitationThumbsLog> list);

  int batchInsert(@Param("list") List<InvitationThumbsLog> list);
}
