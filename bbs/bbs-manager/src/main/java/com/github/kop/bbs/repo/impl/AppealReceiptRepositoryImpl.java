package com.github.kop.bbs.repo.impl;

import com.github.kop.bbs.repo.AppealReceiptRepository;
import com.github.kop.bbs.repo.mapper.AppealReceiptMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:49
 */
@Repository
public class AppealReceiptRepositoryImpl implements AppealReceiptRepository {


    @Resource
    private AppealReceiptMapper appealReceiptMapper;

}
