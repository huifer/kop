package com.github.kop.bbs.service.score.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.ScoreRole;
import com.github.kop.bbs.module.enums.ScoreCycleEnum;
import com.github.kop.bbs.module.enums.ScoreTypeEnum;
import com.github.kop.bbs.module.enums.score.ScoreAddTypeEnum;
import com.github.kop.bbs.module.enums.score.ScoreRoleEnum;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.score.CreateScoreRoleReq;
import com.github.kop.bbs.module.req.score.PageListScoreRoleReq;
import com.github.kop.bbs.module.req.score.UpdateScoreRoleReq;
import com.github.kop.bbs.module.res.score.ScorePageListRes;
import com.github.kop.bbs.repo.ScoreRoleRepository;
import com.github.kop.bbs.service.score.ScoreRecordService;
import com.github.kop.bbs.service.score.ScoreRoleService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreRoleServiceImpl implements ScoreRoleService {

  private final CategoryCreateAndUpdateValidate categoryCreateAndUpdateValidate =
      new CategoryCreateAndUpdateValidate();

  @Resource private ScoreRoleRepository scoreRoleRepository;

  @Override
  public Boolean create(CreateScoreRoleReq req) {
    categoryCreateAndUpdateValidate.createValidate(req);
    return scoreRoleRepository.insert(
            ScoreRole.builder()
                .ruleType(req.getRuleType())
                .addType(req.getAddType())
                .score(req.getScore())
                .scoreCycle(req.getScoreCycle())
                .build())
        > 0;
  }

  @Override
  public Boolean update(UpdateScoreRoleReq req) {
    categoryCreateAndUpdateValidate.idValidate(req.getScoreRuleId());
    return scoreRoleRepository.update(
            ScoreRole.builder()
                .scoreRoleId(req.getScoreRuleId())
                .ruleType(req.getRuleType())
                .addType(req.getAddType())
                .score(req.getScore())
                .scoreCycle(req.getScoreCycle())
                .build())
        > 0;
  }

  @Override
  public Boolean delete(Long id) {
    categoryCreateAndUpdateValidate.idValidate(id);
    return scoreRoleRepository.delete(id) > 0;
  }

  @Override
  public IPage<ScorePageListRes> pageList(
      PageListScoreRoleReq pageListScoreRoleReq, Long page, Long size) {
    IPage<ScoreRole> list =
        scoreRoleRepository.pageList(new Page<>(page, size), pageListScoreRoleReq);
    return list.convert(this::conv);
  }

  private ScorePageListRes conv(ScoreRole scoreRole) {
    ScorePageListRes res = new ScorePageListRes();
    res.setScoreRuleId(scoreRole.getScoreRoleId());
    res.setRuleType(ScoreRoleEnum.getDescByCode(scoreRole.getRuleType()));
    res.setAddType(ScoreAddTypeEnum.getDescByCode(scoreRole.getAddType()));
    res.setScore(scoreRole.getScore() == 0 ? "自定义分数" : scoreRole.getScore().toString());
    res.setScoreCycle(com.github.kop.bbs.module.enums.score.ScoreCycleEnum.getDescByCode(scoreRole.getScoreCycle()));
    return res;
  }

  @Autowired private ScoreRecordService scoreRecordService;

  @Override
  public ScoreRole exceededMax(ScoreTypeEnum type, Long userId) {
    // 获取用户id对应积分类型已经获得的积分
    ScoreRole scoreRole = this.scoreRoleRepository.findByType(type.getCode());
    // 周期数字
    Integer cycleNum = scoreRole.getCycleNum();
    // 周期类型
    Integer scoreCycle = scoreRole.getScoreCycle();

    // 获取用户第一次获取积分的日期

    LocalDateTime startTime = scoreRecordService.firstGetScore(scoreRole.getScoreRoleId(), userId);
    // 计算周期范围内的最后一天
    ScoreCycleEnum scoreCycleEnum = ScoreCycleEnum.conv(scoreCycle);

    LocalDateTime endTime = calcEndTime(startTime, scoreCycleEnum, cycleNum);
    // 计算时间范围内获得的积分
    Long sumScore =
        scoreRecordService.sumScoreByRule(scoreRole.getScoreRoleId(), userId, startTime, endTime);

    Long maxScore = scoreRole.getMaxScore();
    if (maxScore == null || maxScore == 0) {
      return scoreRole;
    } else {

      // 获取的积分在范围内
      if (maxScore > sumScore) {
        return scoreRole;
      } else {
        throw new RuntimeException("积分超过限额");
      }
    }
  }

  /**
   * 计算截至时间
   *
   * @param startTime 开始时间
   * @param scoreCycleEnum 周期类型
   * @param cycleNum 周期天数
   * @return 截至时间
   */
  private LocalDateTime calcEndTime(
      LocalDateTime startTime, ScoreCycleEnum scoreCycleEnum, Integer cycleNum) {
    if (cycleNum == null) {
      throw new RuntimeException("周期数值必填");
    }
    switch (scoreCycleEnum) {
      case DAY:
        return startTime.plusDays(cycleNum);
      case WEEK:
        return startTime.plusDays(7L * cycleNum);
      case YEAR:
        return startTime.plusDays(365L * cycleNum);
      case MONTH:
        return startTime.plusDays(30L * cycleNum);
      default:
        throw new RuntimeException("无法计算截至时间");
    }
  }

  protected class CategoryCreateAndUpdateValidate
      implements CreateValidate<CreateScoreRoleReq>, UpdateValidate<UpdateScoreRoleReq> {

    @Override
    public void createValidate(CreateScoreRoleReq createScoreRoleReq) throws ValidateException {
      // todo: 数据合法性校验 ScoreOperationEnums、ScoreTypeEnums
      if (ObjectUtils.isEmpty(createScoreRoleReq.getRuleType())) {
        throw new ValidateException("积分类型不能为空");
      }
      if (ObjectUtils.isEmpty(createScoreRoleReq.getAddType())) {
        throw new ValidateException("增减类型不能为空");
      }
      if (ObjectUtils.isEmpty(createScoreRoleReq.getScore())) {
        throw new ValidateException("积分数量不能为空");
      }
      if (ObjectUtils.isEmpty(createScoreRoleReq.getScoreCycle())) {
        throw new ValidateException("积分周期不能为空");
      }
    }

    @Override
    public void updateValidate(UpdateScoreRoleReq updateScoreRoleReq) throws ValidateException {}
  }
}
