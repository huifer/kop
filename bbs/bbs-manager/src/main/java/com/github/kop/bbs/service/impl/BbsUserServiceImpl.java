package com.github.kop.bbs.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.kop.bbs.repo.mapper.BbsUserMapper;
import com.github.kop.bbs.module.entity.BbsUser;
import com.github.kop.bbs.service.BbsUserService;
@Service
public class BbsUserServiceImpl extends ServiceImpl<BbsUserMapper, BbsUser> implements BbsUserService{

    @Override
    public int updateBatchSelective(List<BbsUser> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<BbsUser> list) {
        return baseMapper.batchInsert(list);
    }
}
