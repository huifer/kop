package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.BbsCollectionLog;
import java.util.List;
import com.github.kop.bbs.repo.mapper.BbsCollectionLogMapper;
import com.github.kop.bbs.service.BbsCollectionLogService;
@Service
public class BbsCollectionLogServiceImpl extends ServiceImpl<BbsCollectionLogMapper, BbsCollectionLog> implements BbsCollectionLogService{

    @Override
    public int updateBatchSelective(List<BbsCollectionLog> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsCollectionLog> list) {
        return baseMapper.batchInsert(list);
    }
}
