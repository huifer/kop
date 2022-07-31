package com.github.kop.blob.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.module.entity.BlogSpecialColumn;
import com.github.kop.blob.repo.mapper.BlogSpecialColumnMapper;
import com.github.kop.blob.service.BlogSpecialColumnService;

@Service
public class BlogSpecialColumnServiceImpl extends ServiceImpl<BlogSpecialColumnMapper, BlogSpecialColumn> implements BlogSpecialColumnService {

    @Override
    public int updateBatchSelective(List<BlogSpecialColumn> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<BlogSpecialColumn> list) {
        return baseMapper.batchInsert(list);
    }
}



