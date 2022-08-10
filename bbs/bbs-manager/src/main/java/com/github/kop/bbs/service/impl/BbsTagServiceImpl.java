package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.BbsTag;
import java.util.List;
import com.github.kop.bbs.repo.mapper.BbsTagMapper;
import com.github.kop.bbs.service.BbsTagService;
@Service
public class BbsTagServiceImpl extends ServiceImpl<BbsTagMapper, BbsTag> implements BbsTagService{

    @Override
    public int updateBatchSelective(List<BbsTag> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsTag> list) {
        return baseMapper.batchInsert(list);
    }
}
