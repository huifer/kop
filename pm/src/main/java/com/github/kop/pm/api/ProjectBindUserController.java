package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.ProjectBindUserDTO;
import com.github.kop.pm.http.vo.ProjectBindUserQueryVO;
import com.github.kop.pm.http.vo.ProjectBindUserUpdateVO;
import com.github.kop.pm.http.vo.ProjectBindUserVO;
import com.github.kop.pm.service.ProjectBindUserService;
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

@Api(tags = "项目和人")
@Validated
@RestController
@RequestMapping("/projectBindUser")
public class ProjectBindUserController {

  @Autowired
  private ProjectBindUserService projectBindUserService;

  @PostMapping
  @ApiOperation("保存 项目和人")
  public String save(@Valid @RequestBody ProjectBindUserVO vO) {
    return projectBindUserService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 项目和人")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    projectBindUserService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 项目和人")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody ProjectBindUserUpdateVO vO) {
    projectBindUserService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 项目和人")
  public ProjectBindUserDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return projectBindUserService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 项目和人")
  public Page<ProjectBindUserDTO> query(@Valid ProjectBindUserQueryVO vO) {
    return projectBindUserService.query(vO);
  }
}
