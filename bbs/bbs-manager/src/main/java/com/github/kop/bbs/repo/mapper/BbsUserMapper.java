package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsUser;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsUserMapper extends BaseMapper<BbsUser> {
    int updateBatchSelective(List<BbsUser> list);

    int batchInsert(@Param("list") List<BbsUser> list);
}