package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.blob.module.entity.BlogCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {
    int updateBatchSelective(List<BlogCategory> list);

    int batchInsert(@Param("list") List<BlogCategory> list);
}