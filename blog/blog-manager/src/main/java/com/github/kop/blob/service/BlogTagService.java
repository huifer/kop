package com.github.kop.blob.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.blob.module.entity.BlogTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.blob.module.req.tag.BlogTagAddReq;
import com.github.kop.blob.module.res.tag.TagListRes;

public interface BlogTagService extends IService<BlogTag> {


    int updateBatchSelective(List<BlogTag> list);

    int batchInsert(List<BlogTag> list);

    int add(BlogTagAddReq req);

    IPage<TagListRes> listByUserId(Long userId, Long page, Long size);
}



