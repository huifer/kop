package com.github.kop.questionnaire.service.impl;

import com.github.kop.questionnaire.entity.Answer;
import com.github.kop.questionnaire.mapper.AnswerMapper;
import com.github.kop.questionnaire.service.IAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问卷结果表 服务实现类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {

}
