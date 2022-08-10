package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.repo.mapper.BbsUserScoreMapper;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsUserScore;
import com.github.kop.bbs.service.BbsUserScoreService;
@Service
public class BbsUserScoreServiceImpl extends ServiceImpl<BbsUserScoreMapper, BbsUserScore> implements BbsUserScoreService{

    @Override
    public int updateBatchSelective(List<BbsUserScore> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsUserScore> list) {
        return baseMapper.batchInsert(list);
    }
}
