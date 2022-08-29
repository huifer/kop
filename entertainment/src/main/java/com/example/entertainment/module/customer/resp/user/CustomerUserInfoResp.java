package com.example.entertainment.module.customer.resp.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

@ApiModel("用户登录参数，用户详情参数")
@Data
public class CustomerUserInfoResp {

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  @ApiModelProperty("会员账号")
  private String member;


  @ApiModelProperty("昵称")
  private String nickName;

  @ApiModelProperty("头像")
  private String headImage;

  @ApiModelProperty("手机号")
  private String phone;
  @ApiModelProperty("上级会员手机号")
  private String parentPhone;


  @ApiModelProperty("邀请码")
  private String uuid;

  @ApiModelProperty("直推会员人数")
  private Integer totalDirect;

  @ApiModelProperty("会员登录时间")
  private LocalDateTime loginTime;

  @ApiModelProperty("推荐人id")
  private Integer parentMember;

  @ApiModelProperty("实名认证")
  private Integer isAuth;


  @ApiModelProperty("token")
  private String token;
}
