package com.github.kop.blob.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.entity.BlogTag;
import com.github.kop.blob.module.req.tag.BlogTagAddReq;
import com.github.kop.blob.module.res.tag.TagListRes;
import java.util.List;

public interface BlogTagService extends IService<BlogTag> {

  int updateBatchSelective(List<BlogTag> list);

  int batchInsert(List<BlogTag> list);

  int add(BlogTagAddReq req);

  IPage<TagListRes> listByUserId(Long userId, Long page, Long size);
}
