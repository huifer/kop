package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.BbsAppeal;
import com.github.kop.bbs.repo.mapper.BbsAppealMapper;
import java.util.List;
import com.github.kop.bbs.service.BbsAppealService;
@Service
public class BbsAppealServiceImpl extends ServiceImpl<BbsAppealMapper, BbsAppeal> implements BbsAppealService{

    @Override
    public int updateBatchSelective(List<BbsAppeal> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsAppeal> list) {
        return baseMapper.batchInsert(list);
    }
}
