package com.github.kop.bbs.api.manager;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.req.appeal.AppealManagerPageReq;
import com.github.kop.bbs.module.req.appeal.ReplyAppealReq;
import com.github.kop.bbs.module.res.appeal.AppealResp;
import com.github.kop.bbs.module.res.RespVO;
import com.github.kop.bbs.service.appeal.AppealReceiptService;
import com.github.kop.bbs.service.appeal.AppealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "管理的-论坛申诉")
@RestController
@RequestMapping("/manager/appeal")
public class ManagerAppealController {

  // TODO: 2022/8/26 对申诉进行反馈意见回复

    @Resource
    private AppealService appealService;

    @Resource
    private AppealReceiptService appealReceiptService;

    @ApiOperation(value = "申诉列表")
    @PostMapping("/page/{page}/{size}")
    public RespVO<IPage<AppealResp>> page(
            @PathVariable(value = "page") Long page,
            @PathVariable(value = "size") Long size,
            @RequestBody AppealManagerPageReq req) {
        return RespVO.success(appealService.page(page, size, req));
    }

    @ApiOperation(value = "回复投诉")
    @PostMapping("/page/{appealId}/{appealReceiptId}")
    public RespVO<Boolean> replyAppeal(
            @PathVariable Long appealId,
            @PathVariable(required = false) Long appealReceiptId,
            @RequestBody ReplyAppealReq req) {
        return RespVO.success(appealReceiptService.managerReplyAppeal(appealId, appealReceiptId, req));
    }


}
