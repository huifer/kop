package com.github.kop.rbac.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.rbac.module.entity.RbacUserBindRole;

/**
 * 用户和角色表，区别于角色组关系表，这里是不满足的情况下进行使用 Mapper 接口
 *
 * @author root
 * @since 2022-07-25
 */
public interface RbacUserBindRoleMapper extends BaseMapper<RbacUserBindRole> {}
