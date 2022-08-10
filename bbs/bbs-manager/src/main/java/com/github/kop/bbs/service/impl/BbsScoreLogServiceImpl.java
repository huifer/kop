package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsScoreLog;
import com.github.kop.bbs.repo.mapper.BbsScoreLogMapper;
import com.github.kop.bbs.service.BbsScoreLogService;
@Service
public class BbsScoreLogServiceImpl extends ServiceImpl<BbsScoreLogMapper, BbsScoreLog> implements BbsScoreLogService{

    @Override
    public int updateBatchSelective(List<BbsScoreLog> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsScoreLog> list) {
        return baseMapper.batchInsert(list);
    }
}
