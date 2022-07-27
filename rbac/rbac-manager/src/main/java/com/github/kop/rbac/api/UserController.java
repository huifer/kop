package com.github.kop.rbac.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
}
