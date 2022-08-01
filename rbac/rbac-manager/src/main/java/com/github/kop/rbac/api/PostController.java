package com.github.kop.rbac.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.rbac.module.req.post.CreatePostReq;
import com.github.kop.rbac.module.req.post.QueryPostReq;
import com.github.kop.rbac.module.req.post.UpdatePostReq;
import com.github.kop.rbac.module.res.RespVO;
import com.github.kop.rbac.module.res.post.PostQueryRes;
import com.github.kop.rbac.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "岗位接口")
@RestController
@RequestMapping("/post")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @ApiOperation(value = "创建岗位")
  @PostMapping("/")
  public RespVO<Boolean> create(@RequestBody CreatePostReq req) {
    return RespVO.success(postService.create(req) > 0);
  }

  @ApiOperation(value = "修改岗位")
  @PutMapping("/{id}")
  public RespVO<Boolean> update(
      @PathVariable(value = "id") Long id, @RequestBody UpdatePostReq req) {
    req.setId(id);
    return RespVO.success(postService.update(req) > 0);
  }

  @ApiOperation(value = "获取岗位信息")
  @GetMapping("/{id}")
  public RespVO<PostQueryRes> byId(@PathVariable(value = "id") Long id) {
    return RespVO.success(postService.byId(id));
  }

  @ApiOperation(value = "删除岗位")
  @DeleteMapping("/{id}")
  public RespVO<Boolean> deleteById(@PathVariable(value = "id") Long id) {

    return RespVO.success(postService.deleteById(id) > 0);
  }

  @ApiOperation(value = "岗位查询分页信息")
  @GetMapping("/{page}/{size}")
  public RespVO<IPage<PostQueryRes>> page(
      @PathVariable(value = "page") Long page,
      @PathVariable(value = "size") Long size,
      @RequestBody QueryPostReq req) {

    return RespVO.success(postService.page(page, size, req));
  }

  @ApiOperation(value = "岗位列表")
  @GetMapping("/list")
  public RespVO<List<PostQueryRes>> list(@RequestBody QueryPostReq req) {

    return RespVO.success(postService.list(req));
  }
}
