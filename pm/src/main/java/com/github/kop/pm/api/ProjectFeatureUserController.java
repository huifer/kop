package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectFeatureUserDTO;
import com.github.kop.pm.http.vo.ProjectFeatureUserQueryVO;
import com.github.kop.pm.http.vo.ProjectFeatureUserUpdateVO;
import com.github.kop.pm.http.vo.ProjectFeatureUserVO;
import com.github.kop.pm.service.ProjectFeatureUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目功能参与人")
@Validated
@RestController
@RequestMapping("/projectFeatureUser")
public class ProjectFeatureUserController {

  @Autowired
  private ProjectFeatureUserService projectFeatureUserService;

  @PostMapping
  @ApiOperation("保存 项目功能参与人")
  public String save(@Valid @RequestBody ProjectFeatureUserVO vO) {
    return projectFeatureUserService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目功能参与人")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectFeatureUserService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目功能参与人")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectFeatureUserUpdateVO vO) {
    projectFeatureUserService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目功能参与人")
  public ProjectFeatureUserDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectFeatureUserService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目功能参与人")
  public Page<ProjectFeatureUserDTO> query(@Valid ProjectFeatureUserQueryVO vO) {
    return projectFeatureUserService.query(vO);
  }
}
