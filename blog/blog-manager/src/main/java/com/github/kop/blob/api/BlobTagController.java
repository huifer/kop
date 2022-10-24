package com.github.kop.blob.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.blob.module.req.tag.BlogTagAddReq;
import com.github.kop.blob.module.res.RespVO;
import com.github.kop.blob.module.res.tag.TagListRes;
import com.github.kop.blob.service.BlogTagService;
import com.github.kop.blob.utils.UserInfoThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @auth ahxiaoqi
 * @desc 博客标签控制器
 * @time 2022/7/31 16:30
 */
@Api(value = "博客标签")
@RestController
@RequestMapping("/tag")
public class BlobTagController {

  private final BlogTagService tagService;

  public BlobTagController(BlogTagService tagService) {
    this.tagService = tagService;
  }

  @ApiOperation(value = "添加标签")
  @PostMapping("/add")
  public RespVO<Boolean> add(@RequestBody BlogTagAddReq req) {
    return RespVO.success(tagService.add(req) > 1);
  }

  @ApiOperation(value = "我的标签列表")
  @GetMapping("/list/{page}/{size}")
  public RespVO<IPage<TagListRes>> list(
      @PathVariable(value = "page") Long page, @PathVariable(value = "size") Long size) {
    return RespVO.success(tagService.listByUserId(UserInfoThread.getUserId(), page, size));
  }
}
