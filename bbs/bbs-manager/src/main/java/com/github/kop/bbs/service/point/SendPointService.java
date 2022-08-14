package com.github.kop.bbs.service.point;

import com.github.kop.bbs.event.point.PointEvent;
import com.github.kop.bbs.module.enums.PointTypeEnums;

/**
 * 积分发放接口
 */
public interface SendPointService {


  /**
   * 发放积分
   * @param event  积分事件
   * @return 发放成功失败
   */
  public boolean send(PointEvent event);

  public PointTypeEnums pointType();

}
