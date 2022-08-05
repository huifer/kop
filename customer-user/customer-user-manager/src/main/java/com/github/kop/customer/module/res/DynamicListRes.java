package com.github.kop.customer.module.res;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DynamicListRes {
    private Long userId;
    private String  userName;
    private String msg;
    private LocalDateTime pushTime;
}
