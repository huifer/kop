package com.example.entertainment.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entertainment.module.entity.UsersBalanceLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户余额操作历史 Mapper 接口
 * </p>
 *
 * @author root
 * @since 2022-08-31
 */
@Mapper
public interface UsersBalanceLogMapper extends BaseMapper<UsersBalanceLog> {

}
