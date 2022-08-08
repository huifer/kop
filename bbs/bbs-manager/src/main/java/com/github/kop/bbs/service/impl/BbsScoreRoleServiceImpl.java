package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.BbsScoreRole;
import com.github.kop.bbs.repo.mapper.BbsScoreRoleMapper;
import com.github.kop.bbs.service.BbsScoreRoleService;
@Service
public class BbsScoreRoleServiceImpl extends ServiceImpl<BbsScoreRoleMapper, BbsScoreRole> implements BbsScoreRoleService{

    @Override
    public int updateBatchSelective(List<BbsScoreRole> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsScoreRole> list) {
        return baseMapper.batchInsert(list);
    }
}
