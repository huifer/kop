package com.github.kop.bbs.event.appeal;

import com.github.kop.bbs.module.bo.CustomerAppealReplyBo;
import com.github.kop.bbs.module.enums.message.MessageTypeEnum;
import com.github.kop.bbs.service.message.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/6 21:59
 */
@Slf4j
@Component
public class CustomerAppealReplyListener implements ApplicationListener<CustomerAppealReplyEvent> {

    @Resource
    private MessageService messageService;

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(CustomerAppealReplyEvent event) {
        CustomerAppealReplyBo customerAppealReplyBo = event.getCustomerAppealReplyBo();
        // TODO: 2022/9/6 凭借回复的链接
        messageService.batchSendMessage(0L, Collections.singletonList(customerAppealReplyBo.getUserId()), MessageTypeEnum.SYS_MESSAGE.getCode(),"您的申诉官方已回复");

    }
}
