package com.github.kop.bbs.service.appeal.impl;

import com.github.kop.bbs.repo.AppealReceiptRepository;
import com.github.kop.bbs.service.appeal.AppealReceiptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:48
 */
@Service
public class AppealReceiptImpl implements AppealReceiptService {

    @Resource
    private AppealReceiptRepository appealReceiptRepository;

}
