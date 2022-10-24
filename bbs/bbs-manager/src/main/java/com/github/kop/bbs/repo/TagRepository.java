package com.github.kop.bbs.repo;

import com.github.kop.bbs.module.entity.Tag;

public interface TagRepository {

  boolean verifyName(String tag);

  int insert(Tag build);
}
