package com.github.kop.rbac.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.company.QueryCompanyReq;
import com.github.kop.rbac.module.req.company.UpdateCompanyReq;
import com.github.kop.rbac.module.req.dept.CreateDeptReq;
import com.github.kop.rbac.module.req.dept.QueryDeptReq;
import com.github.kop.rbac.module.req.dept.UpdateDeptReq;
import com.github.kop.rbac.module.res.RespVO;
import com.github.kop.rbac.module.res.company.DeptQueryRes;
import com.github.kop.rbac.module.res.dept.DeptQueryRes;
import com.github.kop.rbac.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "部门接口")
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ApiOperation(value = "创建部门")
    @PostMapping("/")
    public RespVO<Boolean> create(
            @RequestBody CreateDeptReq req
    ) {
        return RespVO.success(deptService.create(req) > 0);
    }

    @ApiOperation(value = "修改部门")
    @PutMapping("/{id}")
    public RespVO<Boolean> update(
            @PathVariable(value = "id") Long id, @RequestBody UpdateDeptReq req) {

        req.setId(id);
        return RespVO.success(deptService.update(req) > 0);
    }

    @ApiOperation(value = "获取部门信息")
    @GetMapping("/{id}")
    public RespVO<DeptQueryRes> byId(@PathVariable(value = "id") Long id) {
        return RespVO.success(deptService.byId(id));
    }

    @ApiOperation(value = "删除部门")
    @DeleteMapping("/{id}")
    public RespVO<Boolean> deleteById(@PathVariable(value = "id") Long id) {

        return RespVO.success(deptService.deleteById(id) > 0);
    }

    @ApiOperation(value = "部门查询分页信息")
    @GetMapping("/{page}/{size}")
    public RespVO<IPage<DeptQueryRes>> page(
            @PathVariable(value = "page") Long page,
            @PathVariable(value = "size") Long size,
            @RequestBody QueryDeptReq req) {

        return RespVO.success(deptService.page(page, size, req));
    }

    @ApiOperation(value = "部门列表")
    @GetMapping("/list")
    public RespVO<List<DeptQueryRes>> list(@RequestBody QueryDeptReq req) {

        return RespVO.success(deptService.list(req));
    }

    @ApiOperation(value = "部门树结构")
    @GetMapping("/tree")
    public RespVO<List<DeptQueryRes>> tree(@RequestBody QueryDeptReq req) {

        return RespVO.success(deptService.tree(req));
    }
}
