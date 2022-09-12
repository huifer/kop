package com.github.kop.questionnaire.service;

import com.github.kop.questionnaire.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 问题表 服务类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
public interface IQuestionService  {

  boolean create(Question question);
}
