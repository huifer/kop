package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectBugExecutorDTO;
import com.github.kop.pm.http.vo.ProjectBugExecutorQueryVO;
import com.github.kop.pm.http.vo.ProjectBugExecutorUpdateVO;
import com.github.kop.pm.http.vo.ProjectBugExecutorVO;
import com.github.kop.pm.service.ProjectBugExecutorService;
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

@Api(tags = "项目bug处理人")
@Validated
@RestController
@RequestMapping("/projectBugExecutor")
public class ProjectBugExecutorController {

  @Autowired
  private ProjectBugExecutorService projectBugExecutorService;

  @PostMapping
  @ApiOperation("保存 项目bug处理人")
  public String save(@Valid @RequestBody ProjectBugExecutorVO vO) {
    return projectBugExecutorService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目bug处理人")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectBugExecutorService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目bug处理人")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectBugExecutorUpdateVO vO) {
    projectBugExecutorService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目bug处理人")
  public ProjectBugExecutorDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectBugExecutorService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目bug处理人")
  public Page<ProjectBugExecutorDTO> query(@Valid ProjectBugExecutorQueryVO vO) {
    return projectBugExecutorService.query(vO);
  }
}
