package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsInvitationThumbsLog;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsInvitationThumbsLogService extends IService<BbsInvitationThumbsLog>{


    int updateBatchSelective(List<BbsInvitationThumbsLog> list);

    int batchInsert(List<BbsInvitationThumbsLog> list);

}
