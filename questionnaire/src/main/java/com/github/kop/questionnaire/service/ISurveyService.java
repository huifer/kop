package com.github.kop.questionnaire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.kop.questionnaire.entity.Survey;
import com.github.kop.questionnaire.req.CreateSurveyReq;
import com.github.kop.questionnaire.resp.SurveyResponse;

/**
 * <p>
 * 问卷表 服务类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
public interface ISurveyService  {

  boolean create(CreateSurveyReq survey);

  /**
   * 发布问卷
   */
  boolean push(CreateSurveyReq id);

  IPage<Survey> page(int page, int size, String name);


  SurveyResponse byId(int id);
}
