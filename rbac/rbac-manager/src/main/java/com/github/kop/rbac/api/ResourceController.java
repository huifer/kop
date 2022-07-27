package com.github.kop.rbac.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "资源接口")
@RestController
@RequestMapping("/resources")
public class ResourceController {
}
