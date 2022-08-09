package com.github.kop.rbac.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.rbac.module.entity.RbacPostBindRoleGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author root
 * @since 2022-08-08
 */
@Mapper
public interface RbacPostBindRoleGroupMapper extends BaseMapper<RbacPostBindRoleGroup> {

    @Select("select role_group_id from rbac_post_bind_role_group where post_id = #{postId}")
    List<Long> findRoleGroupIds(@Param("postId") Long postId);
}
