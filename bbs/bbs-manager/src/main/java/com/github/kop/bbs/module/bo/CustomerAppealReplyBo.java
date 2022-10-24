package com.github.kop.bbs.module.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/6 21:55
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerAppealReplyBo {

  private Long appealReceiptId;

  private Long userId;
}
