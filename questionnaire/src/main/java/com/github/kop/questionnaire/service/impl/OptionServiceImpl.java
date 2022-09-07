package com.github.kop.questionnaire.service.impl;

import com.github.kop.questionnaire.entity.Option;
import com.github.kop.questionnaire.mapper.OptionMapper;
import com.github.kop.questionnaire.service.IOptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题选项表 服务实现类
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@Service
public class OptionServiceImpl extends ServiceImpl<OptionMapper, Option> implements IOptionService {

}
