package com.github.kop.rbac.module.req.company;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyCreateUserReq {

    @ApiModelProperty(value = "姓名")
    private String name;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式")
    private String phone;

    /** 性别 */
    @ApiModelProperty(value = "性别")
    private Integer grade;

    /** 密码 */
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "企业")
    private Long companyId;
}
