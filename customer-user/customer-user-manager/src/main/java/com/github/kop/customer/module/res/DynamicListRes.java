package com.github.kop.customer.module.res;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class DynamicListRes {
  private Long userId;
  private String userName;
  private String msg;
  private LocalDateTime pushTime;
}
