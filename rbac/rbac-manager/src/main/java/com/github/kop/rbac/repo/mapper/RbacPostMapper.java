package com.github.kop.rbac.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.rbac.module.entity.RbacPost;
import org.apache.ibatis.annotations.Mapper;

/**
 * 岗位表 Mapper 接口
 *
 * @author root
 * @since 2022-07-25
 */
@Mapper
public interface RbacPostMapper extends BaseMapper<RbacPost> {}
