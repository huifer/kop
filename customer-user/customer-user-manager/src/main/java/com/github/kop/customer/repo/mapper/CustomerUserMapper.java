package com.github.kop.customer.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.customer.module.entity.CustomerUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表 Mapper 接口
 *
 * @author root
 * @since 2022-08-03
 */
@Mapper
public interface CustomerUserMapper extends BaseMapper<CustomerUser> {
}
