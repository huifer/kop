package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.repo.mapper.BbsInvitationMapper;
import com.github.kop.bbs.module.entity.BbsInvitation;
import com.github.kop.bbs.service.BbsInvitationService;
@Service
public class BbsInvitationServiceImpl extends ServiceImpl<BbsInvitationMapper, BbsInvitation> implements BbsInvitationService{

    @Override
    public int updateBatchSelective(List<BbsInvitation> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsInvitation> list) {
        return baseMapper.batchInsert(list);
    }
}
