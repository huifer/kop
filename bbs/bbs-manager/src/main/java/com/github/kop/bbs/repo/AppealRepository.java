package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Appeal;

public interface AppealRepository {

  int create(Appeal appeal);

  IPage<Appeal> page(Long page, Long size);


}
