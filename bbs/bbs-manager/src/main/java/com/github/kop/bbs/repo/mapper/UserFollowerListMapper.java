package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.UserFollowerList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserFollowerListMapper extends BaseMapper<UserFollowerList> {
    int updateBatchSelective(List<UserFollowerList> list);

    int batchInsert(@Param("list") List<UserFollowerList> list);
}