package com.github.kop.bbs.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.bbs.module.entity.ScoreRole;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.req.score.PageListScoreRoleReq;
import com.github.kop.bbs.repo.ScoreRoleRepository;
import com.github.kop.bbs.repo.mapper.ScoreRoleMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/14 15:32
 */
@Repository
public class ScoreRoleRepositoryImpl implements ScoreRoleRepository {

    @Resource
    private ScoreRoleMapper scoreRoleMapper;

    @Override
    public ScoreRole findByType(int type) {
        QueryWrapper<ScoreRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            .eq(ScoreRole::getRoleType, type);
        return this.scoreRoleMapper.selectOne(queryWrapper);
    }

    @Override
    public int insert(ScoreRole build) {
        checkRoleType(build);
        return scoreRoleMapper.insert(build);
    }

    private void checkRoleType(ScoreRole build) {
        boolean b = hasRoleType(build.getRoleType());
        if (b) {
            throw new RuntimeException("该规则已存在");
        }
    }

    public boolean hasRoleType(int roleType) {
        QueryWrapper<ScoreRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
            .eq(ScoreRole::getRoleType, roleType);
        return scoreRoleMapper.exists(queryWrapper);
    }

    @Override
    public int update(ScoreRole scoreCycle) {
        checkRoleType(scoreCycle);
        return scoreRoleMapper.updateById(scoreCycle);
    }

    @Override
    public int delete(Long id) {
        return scoreRoleMapper.updateById(ScoreRole.builder()
            .roleId(id)
                .deleted(DeletedEnum.TRUE.getCode())
                .build());
    }

    @Override
    public IPage<ScoreRole> pageList(Page<ScoreRole> page, PageListScoreRoleReq pageListScoreRoleReq) {
        QueryWrapper<ScoreRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(ObjectUtils.isNotEmpty(pageListScoreRoleReq.getRoleType()),ScoreRole::getRoleType,pageListScoreRoleReq.getRoleType())
                .eq(ObjectUtils.isNotEmpty(pageListScoreRoleReq.getAddType()),ScoreRole::getAddType,pageListScoreRoleReq.getAddType())
                .eq(ObjectUtils.isNotEmpty(pageListScoreRoleReq.getScore()),ScoreRole::getScore,pageListScoreRoleReq.getScore())
                .eq(ObjectUtils.isNotEmpty(pageListScoreRoleReq.getScoreCycle()),ScoreRole::getScoreCycle,pageListScoreRoleReq.getScoreCycle())
        ;
        return scoreRoleMapper.selectPage(page,queryWrapper);
    }
}
