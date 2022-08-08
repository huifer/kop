package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.repo.mapper.BbsThumbsLogMapper;
import com.github.kop.bbs.module.entity.BbsThumbsLog;
import com.github.kop.bbs.service.BbsThumbsLogService;
@Service
public class BbsThumbsLogServiceImpl extends ServiceImpl<BbsThumbsLogMapper, BbsThumbsLog> implements BbsThumbsLogService{

    @Override
    public int updateBatchSelective(List<BbsThumbsLog> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsThumbsLog> list) {
        return baseMapper.batchInsert(list);
    }
}
