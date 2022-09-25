package com.github.kop.questionnaire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.questionnaire.entity.Survey;
import com.github.kop.questionnaire.req.CreateSurveyReq;
import com.github.kop.questionnaire.resp.SurveyResponse;
import com.github.kop.questionnaire.service.ISurveyService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 问卷表 前端控制器
 * </p>
 *
 * @author Zen Huifer
 * @since 2022-09-07
 */
@RestController
@RequestMapping("/survey")
public class SurveyController {

  @Autowired
  private ISurveyService surveyService;


  /**
   * 第一步：创建问卷
   * @param survey
   * @return
   */
  @PostMapping("/create")
  public ResponseEntity<Boolean> create(
      @RequestBody CreateSurveyReq survey
  ) {
    return ResponseEntity.ok(surveyService.create(survey));
  }

  @PostMapping("/push/")
  public ResponseEntity<Boolean> push(CreateSurveyReq req) {
    return ResponseEntity.ok(this.surveyService.push(req));
  }

  @GetMapping("/page")
  public ResponseEntity<IPage<Survey>> page(
      int page,
      int size,
      String name
  ) {
    return ResponseEntity.ok(this.surveyService.page(page, size, name));
  }

  @GetMapping("byId/{id}")
  public ResponseEntity<SurveyResponse> byId(@PathVariable("id") int id) {
    return ResponseEntity.ok(this.surveyService.byId(id));
  }
}
