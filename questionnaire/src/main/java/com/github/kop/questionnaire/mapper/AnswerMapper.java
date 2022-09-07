package com.github.kop.questionnaire.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.questionnaire.entity.Answer;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 问卷结果表 Mapper 接口
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {

}
