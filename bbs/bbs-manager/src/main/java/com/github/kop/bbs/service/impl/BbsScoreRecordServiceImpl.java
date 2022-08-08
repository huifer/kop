package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.BbsScoreRecord;
import com.github.kop.bbs.repo.mapper.BbsScoreRecordMapper;
import com.github.kop.bbs.service.BbsScoreRecordService;
@Service
public class BbsScoreRecordServiceImpl extends ServiceImpl<BbsScoreRecordMapper, BbsScoreRecord> implements BbsScoreRecordService{

    @Override
    public int updateBatchSelective(List<BbsScoreRecord> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsScoreRecord> list) {
        return baseMapper.batchInsert(list);
    }
}
