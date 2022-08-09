package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsUserBlackList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsUserBlackListMapper extends BaseMapper<BbsUserBlackList> {
    int updateBatchSelective(List<BbsUserBlackList> list);

    int batchInsert(@Param("list") List<BbsUserBlackList> list);
}