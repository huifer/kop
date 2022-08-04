package com.github.kop.customer.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.customer.module.entity.CustomerUserBlack;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户拉黑表 Mapper 接口
 *
 * @author root
 * @since 2022-08-03
 */
@Mapper
public interface CustomerUserBlackMapper extends BaseMapper<CustomerUserBlack> {
    @Select("select black_user_id from customer_user_black where user_id = #{userId}")
    List<Long> blackIds(long userId);
}
