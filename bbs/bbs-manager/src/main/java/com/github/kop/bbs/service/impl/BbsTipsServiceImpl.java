package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.repo.mapper.BbsTipsMapper;
import com.github.kop.bbs.module.entity.BbsTips;
import com.github.kop.bbs.service.BbsTipsService;
@Service
public class BbsTipsServiceImpl extends ServiceImpl<BbsTipsMapper, BbsTips> implements BbsTipsService{

    @Override
    public int updateBatchSelective(List<BbsTips> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsTips> list) {
        return baseMapper.batchInsert(list);
    }
}
