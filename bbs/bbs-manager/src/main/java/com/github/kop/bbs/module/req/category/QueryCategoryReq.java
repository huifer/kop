package com.github.kop.bbs.module.req.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/11 22:28
 */
@Data
public class QueryCategoryReq {

    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    private String categoryName;
}
