package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsCategory;
import com.github.kop.bbs.repo.mapper.BbsCategoryMapper;
import com.github.kop.bbs.service.BbsCategoryService;
@Service
public class BbsCategoryServiceImpl extends ServiceImpl<BbsCategoryMapper, BbsCategory> implements BbsCategoryService{

    @Override
    public int updateBatchSelective(List<BbsCategory> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsCategory> list) {
        return baseMapper.batchInsert(list);
    }
}
