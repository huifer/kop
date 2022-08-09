package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsFeedbackRecord;
import com.github.kop.bbs.repo.mapper.BbsFeedbackRecordMapper;
import com.github.kop.bbs.service.BbsFeedbackRecordService;
@Service
public class BbsFeedbackRecordServiceImpl extends ServiceImpl<BbsFeedbackRecordMapper, BbsFeedbackRecord> implements BbsFeedbackRecordService{

    @Override
    public int updateBatchSelective(List<BbsFeedbackRecord> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsFeedbackRecord> list) {
        return baseMapper.batchInsert(list);
    }
}
