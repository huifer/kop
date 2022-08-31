package com.example.entertainment.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entertainment.module.entity.GoodsUsers;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品用户关系表 Mapper 接口
 * </p>
 *
 * @author root
 * @since 2022-08-31
 */
@Mapper
public interface GoodsUsersMapper extends BaseMapper<GoodsUsers> {

}
