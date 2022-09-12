package com.github.kop.questionnaire.controller;

import com.github.kop.questionnaire.entity.Option;
import com.github.kop.questionnaire.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 问题选项表 前端控制器
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/option")
public class OptionController {

  @Autowired
  private IOptionService optionService;

  @PostMapping("/create")
  public ResponseEntity<Boolean> create(@RequestBody Option option) {
    return ResponseEntity.ok(this.optionService.create(option));
  }
}
