package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsInvitation;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsInvitationService extends IService<BbsInvitation> {


    int updateBatchSelective(List<BbsInvitation> list);

    int batchInsert(List<BbsInvitation> list);

}


