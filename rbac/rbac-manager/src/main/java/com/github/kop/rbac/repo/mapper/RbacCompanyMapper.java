package com.github.kop.rbac.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.rbac.module.entity.RbacCompany;
import org.apache.ibatis.annotations.Mapper;

/**
 * 企业表 Mapper 接口
 *
 * @author root
 * @since 2022-07-25
 */
@Mapper
public interface RbacCompanyMapper extends BaseMapper<RbacCompany> {}
