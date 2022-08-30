package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.repo.VoteTicketLogRepository;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.repo.mapper.VoteTicketLogMapper;
import com.github.kop.bbs.module.entity.VoteTicketLog;
import com.github.kop.bbs.service.category.VoteTicketLogService;
@Service
public class VoteTicketLogServiceImpl implements VoteTicketLogService{

    @Resource
    private VoteTicketLogRepository voteTicketLogRepository;

    @Override
    public int insert(VoteTicketLog build) {
        return voteTicketLogRepository.insert(build);
    }

    @Override
    public Boolean checkByUserIdAndApplyIdList(List<Long> applyIdList, Long userId) {
        return findByUserIdAndApplyIdList(applyIdList,userId).size()>0;
    }


    private List<VoteTicketLog> findByUserIdAndApplyIdList(List<Long> applyIdList, Long userId){
        return voteTicketLogRepository.findByUserIdAndApplyIdList(applyIdList,userId);
    }
}
