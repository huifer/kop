package com.github.kop.customer.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.customer.module.entity.CustomerUserWhite;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户关注表 Mapper 接口
 *
 * @author root
 * @since 2022-08-03
 */
@Mapper
public interface CustomerUserWhiteMapper extends BaseMapper<CustomerUserWhite> {
}
