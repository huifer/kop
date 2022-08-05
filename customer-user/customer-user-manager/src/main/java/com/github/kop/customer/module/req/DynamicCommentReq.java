package com.github.kop.customer.module.req;

import lombok.Data;

@Data
public class DynamicCommentReq {
    private Long userId;
    private String msg;
    private Long dynamicId;
    private Long pid;

}
