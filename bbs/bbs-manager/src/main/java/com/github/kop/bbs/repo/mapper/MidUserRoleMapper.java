package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.MidUserRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色中间表 Mapper 接口
 *
 * @author ahxiaoqi
 * @since 2022-08-13
 */
@Mapper
public interface MidUserRoleMapper extends BaseMapper<MidUserRole> {

  /** 删除角色 */
  int deleteUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

  /**
   * 根据用户id查询角色id
   */
  List<Long> byUserId(@Param("userId") Long userId);
}
