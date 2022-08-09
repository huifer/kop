package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsCommentThumbsLog;
import com.github.kop.bbs.repo.mapper.BbsCommentThumbsLogMapper;
import com.github.kop.bbs.service.BbsCommentThumbsLogService;
@Service
public class BbsCommentThumbsLogServiceImpl extends ServiceImpl<BbsCommentThumbsLogMapper, BbsCommentThumbsLog> implements BbsCommentThumbsLogService{

    @Override
    public int updateBatchSelective(List<BbsCommentThumbsLog> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsCommentThumbsLog> list) {
        return baseMapper.batchInsert(list);
    }
}
