package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.blob.module.entity.BlogComment;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogCommentMapper extends BaseMapper<BlogComment> {
    int updateBatchSelective(List<BlogComment> list);

    int batchInsert(@Param("list") List<BlogComment> list);
}