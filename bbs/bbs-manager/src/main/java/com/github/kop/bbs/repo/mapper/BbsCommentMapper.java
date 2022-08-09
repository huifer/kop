package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.BbsComment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BbsCommentMapper extends BaseMapper<BbsComment> {
    int updateBatchSelective(List<BbsComment> list);

    int batchInsert(@Param("list") List<BbsComment> list);
}