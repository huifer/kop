package com.github.kop.blob.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.blob.module.entity.BlogSpecialColumn;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogSpecialColumnMapper extends BaseMapper<BlogSpecialColumn> {
    int updateBatchSelective(List<BlogSpecialColumn> list);

    int batchInsert(@Param("list") List<BlogSpecialColumn> list);
}