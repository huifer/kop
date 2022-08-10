package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.repo.mapper.BbsCommentMapper;
import com.github.kop.bbs.module.entity.BbsComment;
import com.github.kop.bbs.service.BbsCommentService;
@Service
public class BbsCommentServiceImpl extends ServiceImpl<BbsCommentMapper, BbsComment> implements BbsCommentService{

    @Override
    public int updateBatchSelective(List<BbsComment> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsComment> list) {
        return baseMapper.batchInsert(list);
    }
}
