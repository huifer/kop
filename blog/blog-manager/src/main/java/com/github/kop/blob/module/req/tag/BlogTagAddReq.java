package com.github.kop.blob.module.req.tag;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc 标签添加
 * @time 2022/7/31 16:32
 */
@Data
public class BlogTagAddReq {

  /** 标签名称 */
  @TableField(value = "tag_name")
  private String tagName;
}
