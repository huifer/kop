package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectTaskHistoryDTO;
import com.github.kop.pm.http.vo.ProjectTaskHistoryQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskHistoryUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskHistoryVO;
import com.github.kop.pm.service.ProjectTaskHistoryService;
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

@Api(tags = "项目任务执行历史")
@Validated
@RestController
@RequestMapping("/projectTaskHistory")
public class ProjectTaskHistoryController {

  @Autowired
  private ProjectTaskHistoryService projectTaskHistoryService;

  @PostMapping
  @ApiOperation("保存 项目任务执行历史")
  public String save(@Valid @RequestBody ProjectTaskHistoryVO vO) {
    return projectTaskHistoryService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目任务执行历史")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectTaskHistoryService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目任务执行历史")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectTaskHistoryUpdateVO vO) {
    projectTaskHistoryService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目任务执行历史")
  public ProjectTaskHistoryDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectTaskHistoryService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目任务执行历史")
  public Page<ProjectTaskHistoryDTO> query(@Valid ProjectTaskHistoryQueryVO vO) {
    return projectTaskHistoryService.query(vO);
  }
}
