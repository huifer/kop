package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Invitation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InvitationMapper extends BaseMapper<Invitation> {
  int updateBatchSelective(List<Invitation> list);

  int batchInsert(@Param("list") List<Invitation> list);

  int updateAuditStatus( @Param("auditUserCount") int auditUserCount,
                        @Param("auditThreshold") Integer auditThreshold, @Param("invitationId") Long invitationId);
}
