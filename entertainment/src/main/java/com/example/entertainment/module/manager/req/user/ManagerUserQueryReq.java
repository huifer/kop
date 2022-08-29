package com.example.entertainment.module.manager.req.user;

import com.example.entertainment.module.entity.Users;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("管理端用户查询参数")
@Data
public class ManagerUserQueryReq extends Users {


}
