package com.github.kop.bbs.module.res.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

@ApiModel("动态详情")
@Data
public class UserDynamicResp {

  @ApiModelProperty("话题主键")
  private Long topicId;
  @ApiModelProperty("详细内容")
  private String content;
  @ApiModelProperty("用户名")
  private String username;
  @ApiModelProperty("昵称")
  private String nickname;
  @ApiModelProperty("发布时间")
  private LocalDateTime createTime;


  @ApiModelProperty("点赞数")
  private Long likes;
  @ApiModelProperty("踩数")
  private Long dislikes;

}
