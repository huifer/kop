package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectTaskCollaboratorDTO;
import com.github.kop.pm.http.vo.ProjectTaskCollaboratorQueryVO;
import com.github.kop.pm.http.vo.ProjectTaskCollaboratorUpdateVO;
import com.github.kop.pm.http.vo.ProjectTaskCollaboratorVO;
import com.github.kop.pm.service.ProjectTaskCollaboratorService;
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

@Api(tags = "任务协作人")
@Validated
@RestController
@RequestMapping("/projectTaskCollaborator")
public class ProjectTaskCollaboratorController {

  @Autowired
  private ProjectTaskCollaboratorService projectTaskCollaboratorService;

  @PostMapping
  @ApiOperation("保存 任务协作人")
  public String save(@Valid @RequestBody ProjectTaskCollaboratorVO vO) {
    return projectTaskCollaboratorService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 任务协作人")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectTaskCollaboratorService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 任务协作人")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectTaskCollaboratorUpdateVO vO) {
    projectTaskCollaboratorService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 任务协作人")
  public ProjectTaskCollaboratorDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectTaskCollaboratorService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 任务协作人")
  public Page<ProjectTaskCollaboratorDTO> query(@Valid ProjectTaskCollaboratorQueryVO vO) {
    return projectTaskCollaboratorService.query(vO);
  }
}
