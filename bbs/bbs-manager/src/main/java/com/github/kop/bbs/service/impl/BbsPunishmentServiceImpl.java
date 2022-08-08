package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.BbsPunishment;
import com.github.kop.bbs.repo.mapper.BbsPunishmentMapper;
import com.github.kop.bbs.service.BbsPunishmentService;
@Service
public class BbsPunishmentServiceImpl extends ServiceImpl<BbsPunishmentMapper, BbsPunishment> implements BbsPunishmentService{

    @Override
    public int updateBatchSelective(List<BbsPunishment> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsPunishment> list) {
        return baseMapper.batchInsert(list);
    }
}
