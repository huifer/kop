package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Message;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper extends BaseMapper<Message> {
    int updateBatchSelective(List<Message> list);

    int batchInsert(@Param("list") List<Message> list);
}