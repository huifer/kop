package com.github.kop.blob.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.repo.mapper.BlogCommentMapper;
import com.github.kop.blob.module.entity.BlogComment;
import com.github.kop.blob.service.BlogCommentService;

@Service
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements BlogCommentService {

    @Override
    public int updateBatchSelective(List<BlogComment> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<BlogComment> list) {
        return baseMapper.batchInsert(list);
    }
}



