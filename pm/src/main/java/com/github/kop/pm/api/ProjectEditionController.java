package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectEditionDTO;
import com.github.kop.pm.http.vo.ProjectEditionQueryVO;
import com.github.kop.pm.http.vo.ProjectEditionUpdateVO;
import com.github.kop.pm.http.vo.ProjectEditionVO;
import com.github.kop.pm.service.ProjectEditionService;
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

@Api(tags = "项目版本")
@Validated
@RestController
@RequestMapping("/projectEdition")
public class ProjectEditionController {

  @Autowired
  private ProjectEditionService projectEditionService;

  @PostMapping
  @ApiOperation("保存 项目版本")
  public String save(@Valid @RequestBody ProjectEditionVO vO) {
    return projectEditionService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目版本")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectEditionService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目版本")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectEditionUpdateVO vO) {
    projectEditionService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目版本")
  public ProjectEditionDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectEditionService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目版本")
  public Page<ProjectEditionDTO> query(@Valid ProjectEditionQueryVO vO) {
    return projectEditionService.query(vO);
  }
}
