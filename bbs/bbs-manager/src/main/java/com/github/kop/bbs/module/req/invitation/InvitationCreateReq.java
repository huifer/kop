package com.github.kop.bbs.module.req.invitation;

import com.github.kop.bbs.module.enums.invitation.InvitationTextTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@ApiModel("发帖参数")
@Data
public class InvitationCreateReq {

  @ApiModelProperty("帖子正文类型")
  private Integer textType;

  @ApiModelProperty("论坛板块")
  private Long categoryId;

  @ApiModelProperty("帖子正文")
  private String text;

  @ApiModelProperty("标签")
  private List<Integer> tags;

  private InvitationTextTypeEnum textTypeEnum;

  public String tagStrings() {
    if (tags != null) {
      StringBuffer sb = new StringBuffer();
      tags.forEach(
          str -> {
            sb.append(str).append(",");
          });
      sb.deleteCharAt(sb.length() - 1);
      return sb.toString();
    }
    return null;
  }

  public void setTextType(Integer textType) {
    this.textType = textType;
    this.textTypeEnum = InvitationTextTypeEnum.conv(textType);
  }
}
