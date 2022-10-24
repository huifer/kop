package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectFeatureDTO;
import com.github.kop.pm.http.vo.ProjectFeatureQueryVO;
import com.github.kop.pm.http.vo.ProjectFeatureUpdateVO;
import com.github.kop.pm.http.vo.ProjectFeatureVO;
import com.github.kop.pm.service.ProjectFeatureService;
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

@Api(tags = "项目功能")
@Validated
@RestController
@RequestMapping("/projectFeature")
public class ProjectFeatureController {

  @Autowired
  private ProjectFeatureService projectFeatureService;

  @PostMapping
  @ApiOperation("保存 项目功能")
  public String save(@Valid @RequestBody ProjectFeatureVO vO) {
    return projectFeatureService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目功能")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectFeatureService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目功能")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectFeatureUpdateVO vO) {
    projectFeatureService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目功能")
  public ProjectFeatureDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectFeatureService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目功能")
  public Page<ProjectFeatureDTO> query(@Valid ProjectFeatureQueryVO vO) {
    return projectFeatureService.query(vO);
  }
}
