package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsCommentThumbsLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsCommentThumbsLogMapper extends BaseMapper<BbsCommentThumbsLog> {
    int updateBatchSelective(List<BbsCommentThumbsLog> list);

    int batchInsert(@Param("list") List<BbsCommentThumbsLog> list);
}