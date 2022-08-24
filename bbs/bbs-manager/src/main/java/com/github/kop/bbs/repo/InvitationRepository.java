package com.github.kop.bbs.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Invitation;

public interface InvitationRepository {

  IPage<Invitation> page(Long categoryId, Long page, Long size);

  int  create(Invitation invitation);
}
