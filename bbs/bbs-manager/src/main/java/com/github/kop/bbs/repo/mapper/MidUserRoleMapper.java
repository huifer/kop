package com.github.kop.bbs.repo.mapper;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户角色中间表 Mapper 接口
 * </p>
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */@Mapper
public interface MidUserRoleMapper extends BaseMapper<MidUserRole> {

    /**
     * 删除角色
     * @param midUserRole
     * @return
     */
    int deleteUserRole(MidUserRole midUserRole);
}
