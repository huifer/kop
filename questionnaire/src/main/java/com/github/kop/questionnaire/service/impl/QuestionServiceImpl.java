package com.github.kop.questionnaire.service.impl;

import com.github.kop.questionnaire.entity.Question;
import com.github.kop.questionnaire.mapper.QuestionMapper;
import com.github.kop.questionnaire.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题表 服务实现类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

}
