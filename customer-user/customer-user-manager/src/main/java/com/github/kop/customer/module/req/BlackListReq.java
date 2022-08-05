package com.github.kop.customer.module.req;

import lombok.Data;

@Data
public class BlackListReq {
    private Long userId;
    private Long opUserId;
}
