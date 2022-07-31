package com.github.kop.blob.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.blob.module.ex.ValidateException;
import com.github.kop.blob.module.req.tag.BlogTagAddReq;
import com.github.kop.blob.module.res.tag.TagListRes;
import com.github.kop.blob.utils.CreateValidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.blob.repo.mapper.BlogTagMapper;
import com.github.kop.blob.module.entity.BlogTag;
import com.github.kop.blob.service.BlogTagService;

@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {

    private final TagCreateAndUpdateValidate tagCreateAndUpdateValidate =
            new TagCreateAndUpdateValidate();

    @Override
    public int updateBatchSelective(List<BlogTag> list) {
        return baseMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<BlogTag> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int add(BlogTagAddReq req) {
        tagCreateAndUpdateValidate.createValidate(req);
        return baseMapper.insert(BlogTag.builder()
                .tagName(req.getTagName())
                .build());
    }

    @Override
    public IPage<TagListRes> listByUserId(Long userId, Long page, Long size) {
        Page<BlogTag> ipage = baseMapper.listByUserId(new Page<>(page, size), userId);
        return ipage.convert(this::conv);
    }

    private TagListRes conv(BlogTag blogTag) {
        return TagListRes.builder()
                .tagId(blogTag.getTagId())
                .tagName(blogTag.getTagName())
                .build();
    }

    protected static final class TagCreateAndUpdateValidate
            implements CreateValidate<BlogTagAddReq> {
        @Override
        public void createValidate(BlogTagAddReq req) throws ValidateException {
            if (StringUtils.isEmpty(req.getTagName())) {
                throw new ValidateException("标签名称必填");
            }
        }


    }
}



