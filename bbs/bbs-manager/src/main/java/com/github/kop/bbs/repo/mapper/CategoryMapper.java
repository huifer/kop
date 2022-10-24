package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.Category;
import com.github.kop.bbs.module.req.category.QueryCategoryReq;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

  int updateBatchSelective(List<Category> list);

  int batchInsert(@Param("list") List<Category> list);

  /**
   * 分页查询列表
   *
   * @param req
   * @return
   */
  IPage<Category> listWithPage(Page<Category> objectPage, @Param("req") QueryCategoryReq req);

  List<Category> topList();

  List<Category> subList(@Param("categoryId") Long categoryId);
}
