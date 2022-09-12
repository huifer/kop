package com.github.kop.questionnaire.controller;

import com.github.kop.questionnaire.entity.Question;
import com.github.kop.questionnaire.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 问题表 前端控制器
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

  @Autowired
  private IQuestionService questionService;

  @PostMapping("create")
  public ResponseEntity<Boolean> create(@RequestBody Question question) {
    return ResponseEntity.ok(questionService.create(question));
  }
}
