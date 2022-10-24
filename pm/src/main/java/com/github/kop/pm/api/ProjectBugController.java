package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectBugDTO;
import com.github.kop.pm.http.vo.ProjectBugQueryVO;
import com.github.kop.pm.http.vo.ProjectBugUpdateVO;
import com.github.kop.pm.http.vo.ProjectBugVO;
import com.github.kop.pm.service.ProjectBugService;
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

@Api(tags = "项目bug")
@Validated
@RestController
@RequestMapping("/projectBug")
public class ProjectBugController {

  @Autowired
  private ProjectBugService projectBugService;

  @PostMapping
  @ApiOperation("保存 项目bug")
  public String save(@Valid @RequestBody ProjectBugVO vO) {
    return projectBugService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目bug")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectBugService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目bug")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectBugUpdateVO vO) {
    projectBugService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目bug")
  public ProjectBugDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectBugService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目bug")
  public Page<ProjectBugDTO> query(@Valid ProjectBugQueryVO vO) {
    return projectBugService.query(vO);
  }
}
