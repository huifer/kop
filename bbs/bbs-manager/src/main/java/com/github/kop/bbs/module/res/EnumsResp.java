package com.github.kop.bbs.module.res;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnumsResp {

  private String msg;
  private int code;
}
