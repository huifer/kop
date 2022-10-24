package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectTaskDTO;
import com.github.kop.pm.http.vo.ProjectTaskQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskVO;
import com.github.kop.pm.service.ProjectTaskService;
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

@Api(tags = "项目任务")
@Validated
@RestController
@RequestMapping("/projectTask")
public class ProjectTaskController {

  @Autowired
  private ProjectTaskService projectTaskService;

  @PostMapping
  @ApiOperation("保存 项目任务")
  public String save(@Valid @RequestBody ProjectTaskVO vO) {
    return projectTaskService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目任务")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectTaskService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目任务")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectTaskUpdateVO vO) {
    projectTaskService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目任务")
  public ProjectTaskDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectTaskService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目任务")
  public Page<ProjectTaskDTO> query(@Valid ProjectTaskQueryVO vO) {
    return projectTaskService.query(vO);
  }
}
