package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.BbsInvitationThumbsLog;
import com.github.kop.bbs.repo.mapper.BbsInvitationThumbsLogMapper;
import com.github.kop.bbs.service.BbsInvitationThumbsLogService;
@Service
public class BbsInvitationThumbsLogServiceImpl extends ServiceImpl<BbsInvitationThumbsLogMapper, BbsInvitationThumbsLog> implements BbsInvitationThumbsLogService{

    @Override
    public int updateBatchSelective(List<BbsInvitationThumbsLog> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsInvitationThumbsLog> list) {
        return baseMapper.batchInsert(list);
    }
}
