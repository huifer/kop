package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper 接口
 *
 * @author root
 * @since 2022-08-15
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

  Role byCode(@Param("roleCode") String roleCode);
}
