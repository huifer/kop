package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectTaskExecutorDTO;
import com.github.kop.pm.http.vo.ProjectTaskExecutorQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskExecutorUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskExecutorVO;
import com.github.kop.pm.service.ProjectTaskExecutorService;
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

@Api(tags = "任务执行人")
@Validated
@RestController
@RequestMapping("/projectTaskExecutor")
public class ProjectTaskExecutorController {

  @Autowired
  private ProjectTaskExecutorService projectTaskExecutorService;

  @PostMapping
  @ApiOperation("保存 任务执行人")
  public String save(@Valid @RequestBody ProjectTaskExecutorVO vO) {
    return projectTaskExecutorService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 任务执行人")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectTaskExecutorService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 任务执行人")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectTaskExecutorUpdateVO vO) {
    projectTaskExecutorService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 任务执行人")
  public ProjectTaskExecutorDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectTaskExecutorService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 任务执行人")
  public Page<ProjectTaskExecutorDTO> query(@Valid ProjectTaskExecutorQueryVO vO) {
    return projectTaskExecutorService.query(vO);
  }
}