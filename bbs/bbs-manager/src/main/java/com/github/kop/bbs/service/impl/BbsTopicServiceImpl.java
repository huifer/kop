package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsTopic;
import com.github.kop.bbs.repo.mapper.BbsTopicMapper;
import com.github.kop.bbs.service.BbsTopicService;
@Service
public class BbsTopicServiceImpl extends ServiceImpl<BbsTopicMapper, BbsTopic> implements BbsTopicService{

    @Override
    public int updateBatchSelective(List<BbsTopic> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsTopic> list) {
        return baseMapper.batchInsert(list);
    }
}
