package com.github.kop.questionnaire.mapper;

import com.github.kop.questionnaire.entity.Survey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 问卷表 Mapper 接口
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Mapper
public interface SurveyMapper extends BaseMapper<Survey> {

}
