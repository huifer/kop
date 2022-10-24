package com.github.kop.blob.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogFocus;
import java.util.List;

public interface BlogFocusService extends IService<BlogFocus> {

  int updateBatchSelective(List<BlogFocus> list);

  int batchInsert(List<BlogFocus> list);
}
