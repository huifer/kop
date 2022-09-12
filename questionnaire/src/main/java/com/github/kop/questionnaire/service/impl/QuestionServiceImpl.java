package com.github.kop.questionnaire.service.impl;

import com.github.kop.questionnaire.entity.Question;
import com.github.kop.questionnaire.mapper.QuestionMapper;
import com.github.kop.questionnaire.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 问题表 服务实现类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Service
public class QuestionServiceImpl implements IQuestionService {

  @Autowired
  private QuestionMapper questionMapper;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(Question question) {
    return questionMapper.insert(question) > 0;
  }
}
