package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.UserBlackList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBlackListMapper extends BaseMapper<UserBlackList> {
  int updateBatchSelective(List<UserBlackList> list);

  int batchInsert(@Param("list") List<UserBlackList> list);
}
