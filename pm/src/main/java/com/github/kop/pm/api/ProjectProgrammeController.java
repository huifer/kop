package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectProgrammeDTO;
import com.github.kop.pm.http.vo.ProjectProgrammeQueryVO;
import com.github.kop.pm.http.vo.ProjectProgrammeUpdateVO;
import com.github.kop.pm.http.vo.ProjectProgrammeVO;
import com.github.kop.pm.service.ProjectProgrammeService;
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

@Api(tags = "工程")
@Validated
@RestController
@RequestMapping("/projectProgramme")
public class ProjectProgrammeController {

  @Autowired
  private ProjectProgrammeService projectProgrammeService;

  @PostMapping
  @ApiOperation("保存 工程")
  public String save(@Valid @RequestBody ProjectProgrammeVO vO) {
    return projectProgrammeService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 工程")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectProgrammeService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 工程")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectProgrammeUpdateVO vO) {
    projectProgrammeService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 工程")
  public ProjectProgrammeDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectProgrammeService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 工程")
  public Page<ProjectProgrammeDTO> query(@Valid ProjectProgrammeQueryVO vO) {
    return projectProgrammeService.query(vO);
  }
}
