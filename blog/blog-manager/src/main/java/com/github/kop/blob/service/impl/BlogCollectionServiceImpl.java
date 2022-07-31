package com.github.kop.blob.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.repo.mapper.BlogCollectionMapper;
import com.github.kop.blob.module.entity.BlogCollection;
import com.github.kop.blob.service.BlogCollectionService;

@Service
public class BlogCollectionServiceImpl extends ServiceImpl<BlogCollectionMapper, BlogCollection> implements BlogCollectionService {

    @Override
    public int updateBatchSelective(List<BlogCollection> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<BlogCollection> list) {
        return baseMapper.batchInsert(list);
    }
}



