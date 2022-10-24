package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectFileDTO;
import com.github.kop.pm.http.vo.ProjectFileQueryVO;
import com.github.kop.pm.http.vo.ProjectFileUpdateVO;
import com.github.kop.pm.http.vo.ProjectFileVO;
import com.github.kop.pm.service.ProjectFileService;
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

@Api(tags = "项目文件")
@Validated
@RestController
@RequestMapping("/projectFile")
public class ProjectFileController {

  @Autowired
  private ProjectFileService projectFileService;

  @PostMapping
  @ApiOperation("保存 项目文件")
  public String save(@Valid @RequestBody ProjectFileVO vO) {
    return projectFileService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目文件")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectFileService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目文件")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectFileUpdateVO vO) {
    projectFileService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目文件")
  public ProjectFileDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectFileService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目文件")
  public Page<ProjectFileDTO> query(@Valid ProjectFileQueryVO vO) {
    return projectFileService.query(vO);
  }
}
