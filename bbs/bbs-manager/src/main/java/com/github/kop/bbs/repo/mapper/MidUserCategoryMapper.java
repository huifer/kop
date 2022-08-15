package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.MidUserCategory;
import org.apache.ibatis.annotations.Mapper;

/**
 * 版主与分类的中间表 Mapper 接口
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Mapper
public interface MidUserCategoryMapper extends BaseMapper<MidUserCategory> {}
