package com.github.kop.bbs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.ScoreRole;
import com.github.kop.bbs.module.enums.score.ScoreAddTypeEnum;
import com.github.kop.bbs.module.enums.score.ScoreCycleEnum;
import com.github.kop.bbs.module.enums.score.ScoreRoleEnum;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.score.CreateScoreRoleReq;
import com.github.kop.bbs.module.req.score.PageListScoreRoleReq;
import com.github.kop.bbs.module.req.score.UpdateScoreRoleReq;
import com.github.kop.bbs.module.res.score.ScorePageListRes;
import com.github.kop.bbs.repo.ScoreRoleRepository;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import com.github.kop.bbs.service.ScoreRoleService;

import javax.annotation.Resource;

@Service
public class ScoreRoleServiceImpl implements ScoreRoleService {

    private final CategoryCreateAndUpdateValidate categoryCreateAndUpdateValidate = new CategoryCreateAndUpdateValidate();

    @Resource
    private ScoreRoleRepository scoreRoleRepository;

    @Override
    public Boolean create(CreateScoreRoleReq req) {
        categoryCreateAndUpdateValidate.createValidate(req);
        return scoreRoleRepository.insert(ScoreRole.builder()
                        .roleType(req.getRoleType())
                        .addType(req.getAddType())
                        .score(req.getScore())
                        .scoreCycle(req.getScoreCycle())
                .build()) > 0 ;
    }

    @Override
    public Boolean update(UpdateScoreRoleReq req) {
        categoryCreateAndUpdateValidate.idValidate(req.getRoleId());
        return scoreRoleRepository.update(ScoreRole.builder()
                .roleId(req.getRoleId())
                .roleType(req.getRoleType())
                .addType(req.getAddType())
                .score(req.getScore())
                .scoreCycle(req.getScoreCycle())
                .build()) > 0;
    }

    @Override
    public Boolean delete(Long id) {
        categoryCreateAndUpdateValidate.idValidate(id);
        return scoreRoleRepository.delete(id) >0;
    }

    @Override
    public IPage<ScorePageListRes> pageList(PageListScoreRoleReq pageListScoreRoleReq, Long page, Long size) {
        IPage<ScoreRole> list =  scoreRoleRepository.pageList(new Page<>(page, size),pageListScoreRoleReq);
        return list.convert(this::conv);
    }


    private ScorePageListRes conv(ScoreRole scoreRole) {
        ScorePageListRes res = new ScorePageListRes();
        res.setRoleId(scoreRole.getRoleId());
        res.setRoleType(ScoreRoleEnum.getDescByCode(scoreRole.getRoleType()));
        res.setAddType(ScoreAddTypeEnum.getDescByCode(scoreRole.getAddType()));
        res.setScore(scoreRole.getScore() == 0 ? "自定义分数" : scoreRole.getScore().toString());
        res.setScoreCycle(ScoreCycleEnum.getDescByCode(scoreRole.getScoreCycle()));
        return res;
    }

    protected class CategoryCreateAndUpdateValidate
            implements CreateValidate<CreateScoreRoleReq>, UpdateValidate<UpdateScoreRoleReq> {

        @Override
        public void createValidate(CreateScoreRoleReq createScoreRoleReq) throws ValidateException {
            if(ObjectUtils.isEmpty(createScoreRoleReq.getRoleType())){
                throw new ValidateException("积分类型不能为空");
            }
            if(ObjectUtils.isEmpty(createScoreRoleReq.getAddType())){
                throw new ValidateException("增减类型不能为空");
            }
            if(ObjectUtils.isEmpty(createScoreRoleReq.getScore())){
                throw new ValidateException("积分数量不能为空");
            }
            if(ObjectUtils.isEmpty(createScoreRoleReq.getScoreCycle())){
                throw new ValidateException("积分周期不能为空");
            }
        }

        @Override
        public void updateValidate(UpdateScoreRoleReq updateScoreRoleReq) throws ValidateException {

        }
    }
}
