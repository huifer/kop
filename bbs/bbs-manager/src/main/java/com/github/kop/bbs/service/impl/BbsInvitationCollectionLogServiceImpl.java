package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.module.entity.BbsInvitationCollectionLog;
import com.github.kop.bbs.repo.mapper.BbsInvitationCollectionLogMapper;
import com.github.kop.bbs.service.BbsInvitationCollectionLogService;
@Service
public class BbsInvitationCollectionLogServiceImpl extends ServiceImpl<BbsInvitationCollectionLogMapper, BbsInvitationCollectionLog> implements BbsInvitationCollectionLogService{

    @Override
    public int updateBatchSelective(List<BbsInvitationCollectionLog> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsInvitationCollectionLog> list) {
        return baseMapper.batchInsert(list);
    }
}
