package com.github.kop.customer.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.customer.module.entity.CustomerUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerUserMapper extends BaseMapper<CustomerUser> {
}
