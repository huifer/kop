package com.example.entertainment.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entertainment.module.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户订单，商家市场，二级市场的订单 Mapper 接口
 * </p>
 *
 * @author root
 * @since 2022-08-31
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
