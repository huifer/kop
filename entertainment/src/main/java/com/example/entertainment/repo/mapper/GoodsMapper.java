package com.example.entertainment.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entertainment.module.entity.Goods;
import java.time.LocalDateTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 系列商品表 Mapper 接口
 * </p>
 *
 * @author root
 * @since 2022-08-29
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

  @Select("select  min(start_time) from ent_goods where goods_category_id = #{category}")
  LocalDateTime minStartTimeByCategory(@Param("category") int category);
}
