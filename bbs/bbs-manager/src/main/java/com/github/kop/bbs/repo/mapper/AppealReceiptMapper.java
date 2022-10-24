package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.AppealReceipt;
import org.apache.ibatis.annotations.Select;

public interface AppealReceiptMapper extends BaseMapper<AppealReceipt> {
  @Select(
      "select * from bbs_appeal_receipt where appeal_receipt_id = #{appeal_receipt_id} order by `order` desc limit 1")
  AppealReceipt getLastReply(Long appealId);
}
