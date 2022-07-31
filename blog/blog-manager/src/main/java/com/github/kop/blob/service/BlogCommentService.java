package com.github.kop.blob.service;

import java.util.List;
import com.github.kop.blob.module.entity.BlogComment;
import com.baomidou.mybatisplus.extension.service.IService;

public interface BlogCommentService extends IService<BlogComment> {


    int updateBatchSelective(List<BlogComment> list);

    int batchInsert(List<BlogComment> list);

}



