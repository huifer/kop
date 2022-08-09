package com.github.kop.bbs.service;

import java.util.List;
import com.github.kop.bbs.module.entity.BbsCommentThumbsLog;
import com.baomidou.mybatisplus.extension.service.IService;
public interface BbsCommentThumbsLogService extends IService<BbsCommentThumbsLog>{


    int updateBatchSelective(List<BbsCommentThumbsLog> list);

    int batchInsert(List<BbsCommentThumbsLog> list);

}
