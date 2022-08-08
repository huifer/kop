package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.repo.mapper.BbsMessageMapper;
import com.github.kop.bbs.module.entity.BbsMessage;
import com.github.kop.bbs.service.BbsMessageService;
@Service
public class BbsMessageServiceImpl extends ServiceImpl<BbsMessageMapper, BbsMessage> implements BbsMessageService{

    @Override
    public int updateBatchSelective(List<BbsMessage> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsMessage> list) {
        return baseMapper.batchInsert(list);
    }
}
