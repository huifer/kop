package com.github.kop.pm.api;

import com.github.kop.pm.http.dto.UserDTO;
import com.github.kop.pm.http.vo.UserQueryVO;
import com.github.kop.pm.http.vo.UserUpdateVO;
import com.github.kop.pm.http.vo.UserVO;
import com.github.kop.pm.service.UserService;
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

@Api(tags = "用户表")
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  @ApiOperation("保存 用户表")
  public String save(@Valid @RequestBody UserVO vO) {
    return userService.save(vO).toString();
  }

  @DeleteMapping("/{id}")
  @ApiOperation("删除 用户表")
  public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
    userService.delete(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("更新 用户表")
  public void update(@Valid @NotNull @PathVariable("id") Integer id,
      @Valid @RequestBody UserUpdateVO vO) {
    userService.update(id, vO);
  }

  @GetMapping("/{id}")
  @ApiOperation("根据ID获取 用户表")
  public UserDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
    return userService.getById(id);
  }

  @GetMapping
  @ApiOperation("自定义查询 用户表")
  public Page<UserDTO> query(@Valid UserQueryVO vO) {
    return userService.query(vO);
  }
}
