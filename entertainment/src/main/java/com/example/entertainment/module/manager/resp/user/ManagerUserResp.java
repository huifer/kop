package com.example.entertainment.module.manager.resp.user;

import com.example.entertainment.module.entity.Users;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("管理端用户分页返回值")
public class ManagerUserResp extends Users {

}
