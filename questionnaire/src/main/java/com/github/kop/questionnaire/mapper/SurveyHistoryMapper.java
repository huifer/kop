package com.github.kop.questionnaire.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.questionnaire.entity.SurveyHistory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 问卷历史表 Mapper 接口
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
public interface SurveyHistoryMapper extends BaseMapper<SurveyHistory> {

  @Select("select max(sv) from survey_history where survey_id  = #{surveyId} ")
  Integer findMaxSv(@Param("surveyId") Integer surveyId);

  @Select("SELECT a.* FROM `survey_history`  as a\n"
      + "where id = (select b.id from survey_history as b  ORDER BY sv desc limit 1 )")
  SurveyHistory findMaxVersion(@Param("surveyId") Integer surveyId);

  @Select("select a.* from survey_history as a  where used = 1 and  id = (select b.id from survey_history as b  ORDER BY sv desc limit 1 ) ")
  SurveyHistory findNow(int id);
}
