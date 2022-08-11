package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.BbsCategory;
import java.util.List;

import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import org.apache.ibatis.annotations.Param;

public interface BbsCategoryMapper extends BaseMapper<BbsCategory> {
    int updateBatchSelective(List<BbsCategory> list);

    int batchInsert(@Param("list") List<BbsCategory> list);

    /**
     * 分页查询列表
     *
     * @param req
     * @return
     */
    IPage<BbsCategory> listWithPage(Page<BbsCategory> objectPage, @Param("req") QueryCategoryReq req);
}