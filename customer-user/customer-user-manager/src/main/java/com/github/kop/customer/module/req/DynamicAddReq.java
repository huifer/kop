package com.github.kop.customer.module.req;

import lombok.Data;

@Data
public class DynamicAddReq {
  private Long userId;
  private String msg;
}
