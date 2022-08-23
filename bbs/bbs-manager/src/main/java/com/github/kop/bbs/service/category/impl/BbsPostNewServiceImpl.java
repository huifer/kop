package com.github.kop.bbs.service.category.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.module.entity.UserDynamic;
import com.github.kop.bbs.repo.mapper.UserDynamicMapper;
import com.github.kop.bbs.service.category.BbsPostNewService;
@Service
public class BbsPostNewServiceImpl extends ServiceImpl<UserDynamicMapper, UserDynamic> implements BbsPostNewService{

}
