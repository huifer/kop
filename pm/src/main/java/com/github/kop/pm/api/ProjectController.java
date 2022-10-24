package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectDTO;
import com.github.kop.pm.http.vo.ProjectQueryVO;
import com.github.kop.pm.http.vo.ProjectUpdateVO;
import com.github.kop.pm.http.vo.ProjectVO;
import com.github.kop.pm.service.ProjectService;
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

@Api(tags = "项目")
@Validated
@RestController
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @PostMapping
  @ApiOperation("保存 项目")
  public String save(@Valid @RequestBody ProjectVO vO) {
    return projectService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectUpdateVO vO) {
    projectService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目")
  public ProjectDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目")
  public Page<ProjectDTO> query(@Valid ProjectQueryVO vO) {
    return projectService.query(vO);
  }
}
