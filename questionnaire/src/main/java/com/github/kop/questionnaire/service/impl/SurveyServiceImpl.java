package com.github.kop.questionnaire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.questionnaire.entity.Option;
import com.github.kop.questionnaire.entity.OptionImage;
import com.github.kop.questionnaire.entity.Question;
import com.github.kop.questionnaire.entity.QuestionImage;
import com.github.kop.questionnaire.entity.Survey;
import com.github.kop.questionnaire.entity.SurveyHistory;
import com.github.kop.questionnaire.mapper.OptionImageMapper;
import com.github.kop.questionnaire.mapper.OptionMapper;
import com.github.kop.questionnaire.mapper.QuestionImageMapper;
import com.github.kop.questionnaire.mapper.QuestionMapper;
import com.github.kop.questionnaire.mapper.SurveyHistoryMapper;
import com.github.kop.questionnaire.mapper.SurveyMapper;
import com.github.kop.questionnaire.req.CreateSurveyReq;
import com.github.kop.questionnaire.resp.SurveyResponse;
import com.github.kop.questionnaire.resp.SurveyResponse.QuestionResponse;
import com.github.kop.questionnaire.service.ISurveyService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 问卷表 服务实现类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Service
public class SurveyServiceImpl implements ISurveyService {

  @Autowired
  private SurveyMapper surveyMapper;
  @Autowired
  private SurveyHistoryMapper surveyHistoryMapper;
  @Autowired
  private QuestionMapper questionMapper;
  @Autowired
  private OptionMapper optionMapper;
  @Autowired
  private QuestionImageMapper questionImageMapper;
  @Autowired
  private OptionImageMapper optionImageMapper;

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(CreateSurveyReq survey) {
    // 创建问卷
    surveyMapper.insert(survey);
    Integer surveyId = survey.getId();

    // 创建问卷历史
    SurveyHistory entity = new SurveyHistory();
    entity.setSv(findSv(surveyId) + 1);

    entity.setSurveyId(surveyId);
    entity.setUsed(0);

    surveyHistoryMapper.insert(entity);
    return true;
  }

  private Integer findSv(Integer surveyId) {
    Integer maxVersion = surveyHistoryMapper.findMaxSv(surveyId);
    return maxVersion == null ? 0 : maxVersion;
  }

  @Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean push(CreateSurveyReq req) {
    // 问卷状态修改
    Survey survey = this.surveyMapper.selectById(req.getId());
    survey.setStatus(1);
    this.surveyMapper.updateById(survey);

    // 问卷历史使用项选择版本号最大的
    SurveyHistory surveyHistory = this.surveyHistoryMapper.findMaxVersion(req.getId());
    surveyHistory.setUsed(1);
    this.surveyHistoryMapper.updateById(surveyHistory);

    // 镜像数据拷贝
    copyImage(req.getId(), req.getQuestionIds());
    return true;
  }

  private void copyImage(Integer surveyId, List<Integer> questionIds) {
    List<Question> questions = this.questionMapper.selectBatchIds(questionIds);

    for (Question question : questions) {
      QuestionImage questionImage = new QuestionImage();
      questionImage.setSurveyId(surveyId);
      questionImage.setType(question.getType());
      questionImage.setName(question.getName());
      questionImage.setSort(question.getSort());
      questionImage.setRequire(question.getRequire());
      questionImage.setSourceId(question.getId());

      this.questionImageMapper.insert(questionImage);
      QueryWrapper<Option> queryWrapper = new QueryWrapper<>();
      queryWrapper.lambda()
          .eq(Option::getQuestionId, question.getId());
      List<Option> options = this.optionMapper.selectList(queryWrapper);
      for (Option option : options) {
        OptionImage optionImage = new OptionImage();
        optionImage.setSurveyId(surveyId);
        optionImage.setQuestionId(question.getId());
        optionImage.setName(option.getName());
        optionImage.setSourceId(option.getId());
        this.optionImageMapper.insert(optionImage);

      }

    }
  }

  @Override
  public IPage<Survey> page(int page, int size, String name) {
    QueryWrapper<Survey> queryWrapper = new QueryWrapper<>();
    queryWrapper.lambda().like(StringUtils.isNotBlank(name), Survey::getName, name);
    return this.surveyMapper.selectPage(new Page<>(page, size), queryWrapper);
  }

  @Override
  public SurveyResponse byId(int id) {
    Survey survey = this.surveyMapper.selectById(id);

    SurveyHistory surveyHistory = this.surveyHistoryMapper.findNow(id);
    if (surveyHistory != null) {
      SurveyResponse surveyResponse = new SurveyResponse();

      surveyResponse.setId(surveyHistory.getSurveyId());
      surveyResponse.setName(survey.getName());
      surveyResponse.setDescription(survey.getDescription());

      ArrayList<QuestionResponse> questionImagesRes = new ArrayList<>();

      QueryWrapper<QuestionImage> queryWrapper = new QueryWrapper<>();
      queryWrapper.lambda()
          .eq(QuestionImage::getSurveyId, survey.getId())
      ;
      List<QuestionImage> questionImages = this.questionImageMapper.selectList(queryWrapper);
      for (QuestionImage questionImage : questionImages) {
        QuestionResponse e = new QuestionResponse();
        ArrayList<OptionImage> optRes = new ArrayList<>();

        QueryWrapper<OptionImage> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(OptionImage::getQuestionId, questionImage.getSourceId());
        List<OptionImage> optionImages = this.optionImageMapper.selectList(queryWrapper1);
        for (OptionImage optionImage : optionImages) {
          OptionImage e1 = new OptionImage();
          e1.setId(optionImage.getId());
          e1.setSurveyId(optionImage.getSurveyId());
          e1.setQuestionId(optionImage.getQuestionId());
          e1.setName(optionImage.getName());
          e1.setSourceId(optionImage.getSourceId());

          optionImages.add(e1);
        }
        e.setOptionImages(optRes);
        e.setId(questionImage.getId());
        e.setSurveyId(questionImage.getSurveyId());
        e.setType(questionImage.getType());
        e.setName(questionImage.getName());
        e.setSort(questionImage.getSort());
        e.setRequire(questionImage.getRequire());
        e.setSourceId(questionImage.getSourceId());

        questionImagesRes.add(e);
      }
      surveyResponse.setQuestionImages(questionImagesRes);
      return surveyResponse;
    }
    return null;
  }
}
