package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.repo.mapper.BbsUserBlackListMapper;
import com.github.kop.bbs.module.entity.BbsUserBlackList;
import com.github.kop.bbs.service.BbsUserBlackListService;
@Service
public class BbsUserBlackListServiceImpl extends ServiceImpl<BbsUserBlackListMapper, BbsUserBlackList> implements BbsUserBlackListService{

    @Override
    public int updateBatchSelective(List<BbsUserBlackList> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsUserBlackList> list) {
        return baseMapper.batchInsert(list);
    }
}
