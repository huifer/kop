package com.github.kop.blob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogComment;
import java.util.List;

public interface BlogCommentService extends IService<BlogComment> {

  int updateBatchSelective(List<BlogComment> list);

  int batchInsert(List<BlogComment> list);
}
