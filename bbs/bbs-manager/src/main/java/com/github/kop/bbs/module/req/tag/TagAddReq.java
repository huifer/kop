package com.github.kop.bbs.module.req.tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/1 21:41
 */
@ApiModel("标签添加请求对象")
@Data
public class TagAddReq {

    /** 标签名 */
    @ApiModelProperty(value = "标签名")
    private String tag;

}
