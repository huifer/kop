package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsComment;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BbsCommentService extends IService<BbsComment> {


    int updateBatchSelective(List<BbsComment> list);

    int batchInsert(List<BbsComment> list);

}


