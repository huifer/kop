package com.github.kop.bbs.event.invitation;

import com.github.kop.bbs.module.entity.MidUserRole;
import com.github.kop.bbs.module.enums.message.MessageTypeEnum;
import com.github.kop.bbs.module.enums.role.RoleEnum;
import com.github.kop.bbs.service.message.MessageService;
import com.github.kop.bbs.service.user.MidUserRoleService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/9/5 22:01
 */
@Slf4j
@Component
public class InvitationListener implements ApplicationListener<InvitationCreated> {

  @Resource private MessageService messageService;

  @Resource private MidUserRoleService midUserRoleService;

  /**
   * Handle an application event.
   *
   * @param event the event to respond to
   */
  @Override
  public void onApplicationEvent(InvitationCreated event) {
    List<MidUserRole> auditUserList = midUserRoleService.findByRole(RoleEnum.AUDIT.getRoleCode());
    if (ObjectUtils.isNotEmpty(auditUserList)) {
      List<Long> userIds =
          auditUserList.stream().map(MidUserRole::getUserId).collect(Collectors.toList());
      Long invitationId = event.getInvitationId();
      // TODO: 2022/9/5 审核跳转连接拼接
      messageService.batchSendMessage(
          0L, userIds, MessageTypeEnum.SYS_MESSAGE.getCode(), "您有新的帖子待审核");
    }
  }
}
