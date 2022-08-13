package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.CommentThumbsLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentThumbsLogMapper extends BaseMapper<CommentThumbsLog> {
    int updateBatchSelective(List<CommentThumbsLog> list);

    int batchInsert(@Param("list") List<CommentThumbsLog> list);
}