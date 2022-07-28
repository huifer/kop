package com.github.kop.rbac.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.kop.rbac.module.entity.RbacDept;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import com.github.kop.rbac.repo.DeptRepository;
import com.github.kop.rbac.repo.mapper.RbacDeptMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeptRepositoryImpl implements DeptRepository {
    @Autowired
    private RbacDeptMapper deptMapper;

    @Override
    public RbacDept byId(Long id) {
        return deptMapper.selectById(id);
    }

    @Override
    public int create(RbacDept rbacDept) {
        return this.deptMapper.insert(rbacDept);
    }

    @Override
    public int update(RbacDept rbacDept) {
        return this.deptMapper.updateById(rbacDept);
    }

    @Override
    public List<RbacDept> findByCompanyId(Long companyId) {
        QueryWrapper<RbacDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RbacDept::getCompanyId, companyId);
        return this.deptMapper.selectList(queryWrapper);
    }

    @Override
    public List<RbacDept> findByDeptIdForChild(Long deptId) {
        QueryWrapper<RbacDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(RbacDept::getId, deptId)
                .or()
                .eq(RbacDept::getPid, deptId);
        return this.deptMapper.selectList(queryWrapper);

    }

    @Override
    public int deleteById(Long id) {
        return this.deptMapper.deleteById(id);
    }


    @Override
    public IPage<RbacDept> page(Long page, Long size, QueryDeptReq req) {
        QueryWrapper<RbacDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(StringUtils.isNotBlank(req.getName()), RbacDept::getName, req.getName())
                .like(StringUtils.isNotBlank(req.getDesc()), RbacDept::getDesc, req.getDesc());
        return this.deptMapper.selectPage(new Page<>(page, size), queryWrapper);
    }

    @Override
    public List<RbacDept> list(QueryDeptReq req) {
        QueryWrapper<RbacDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .like(StringUtils.isNotBlank(req.getName()), RbacDept::getName, req.getName())
                .like(StringUtils.isNotBlank(req.getDesc()), RbacDept::getDesc, req.getDesc());
        return this.deptMapper.selectList(queryWrapper);
    }
}
