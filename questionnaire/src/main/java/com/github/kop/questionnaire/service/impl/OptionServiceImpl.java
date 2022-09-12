package com.github.kop.questionnaire.service.impl;

import com.github.kop.questionnaire.entity.Option;
import com.github.kop.questionnaire.mapper.OptionMapper;
import com.github.kop.questionnaire.service.IOptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 问题选项表 服务实现类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Service
public class OptionServiceImpl implements IOptionService {

  @Autowired
  private OptionMapper optionMapper;
@Transactional(rollbackFor = {Exception.class})
  @Override
  public boolean create(Option option) {
    return optionMapper.insert(option) > 0;
  }
}
