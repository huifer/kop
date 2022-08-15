package com.github.kop.rbac.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.rbac.module.entity.RbacRoleBindResource;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 角色与资源关系表 Mapper 接口
 *
 * @author root
 * @since 2022-07-25
 */
public interface RbacRoleBindResourceMapper extends BaseMapper<RbacRoleBindResource> {

  List<Long> findResourceIds(@Param("roleIds") List<Long> roleIds);
}
