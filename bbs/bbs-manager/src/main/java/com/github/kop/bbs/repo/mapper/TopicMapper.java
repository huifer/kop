package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Topic;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper extends BaseMapper<Topic> {
    int updateBatchSelective(List<Topic> list);

    int batchInsert(@Param("list") List<Topic> list);
}