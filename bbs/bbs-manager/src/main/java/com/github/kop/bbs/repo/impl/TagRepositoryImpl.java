package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.kop.bbs.module.entity.Tag;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.repo.TagRepository;
import com.github.kop.bbs.repo.mapper.TagMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TagRepositoryImpl implements TagRepository {

    @Resource
    private TagMapper tagMapper;

    @Override
    public boolean verifyName(String tag) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Tag::getTag,tag)
                .eq(Tag::getDeleted, DeletedEnum.FALSE.getCode());
        return tagMapper.selectCount(queryWrapper) > 0;
    }

    @Override
    public int insert(Tag build) {
        boolean b = verifyName(build.getTag());
        if(b){
            return 1;
        }
        return tagMapper.insert(build);
    }
}
