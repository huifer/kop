package com.github.kop.rbac.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.rbac.module.entity.RbacDept;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 部门表 Mapper 接口
 *
 * @author root
 * @since 2022-07-25
 */
@Mapper
public interface RbacDeptMapper extends BaseMapper<RbacDept> {

  List<Long> findByName(@Param("deptName") String deptName);
}
