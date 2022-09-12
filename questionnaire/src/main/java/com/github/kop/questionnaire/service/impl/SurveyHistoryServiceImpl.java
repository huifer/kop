package com.github.kop.questionnaire.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.questionnaire.entity.SurveyHistory;
import com.github.kop.questionnaire.mapper.SurveyHistoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问卷历史表 服务实现类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Service
public class SurveyHistoryServiceImpl extends ServiceImpl<SurveyHistoryMapper, SurveyHistory> implements
    IService<SurveyHistory> {

}
