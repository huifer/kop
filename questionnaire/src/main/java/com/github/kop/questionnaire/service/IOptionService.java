package com.github.kop.questionnaire.service;

import com.github.kop.questionnaire.entity.Option;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 问题选项表 服务类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
public interface IOptionService  {

  boolean create(Option option);
}