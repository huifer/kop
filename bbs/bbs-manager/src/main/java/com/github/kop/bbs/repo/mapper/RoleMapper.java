package com.github.kop.bbs.repo.mapper;

import com.github.kop.bbs.module.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author root
 * @since 2022-08-15
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

  Role byCode(@Param("roleCode") String roleCode);
}
