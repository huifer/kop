package com.github.kop.bbs.service.category.impl;

import com.github.kop.bbs.module.entity.MidUserCategoryVoteApply;
import com.github.kop.bbs.module.entity.UserCategoryVoteSetting;
import com.github.kop.bbs.module.entity.VoteTicketLog;
import com.github.kop.bbs.module.enums.DeletedEnum;
import com.github.kop.bbs.module.ex.NoceException;
import com.github.kop.bbs.repo.VoteTicketCountRepository;
import com.github.kop.bbs.service.category.MidUserCategoryVoteApplyService;
import com.github.kop.bbs.service.category.UserCategoryVoteSettingService;
import com.github.kop.bbs.service.category.VoteTicketLogService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.kop.bbs.repo.mapper.VoteTicketCountMapper;
import com.github.kop.bbs.module.entity.VoteTicketCount;
import com.github.kop.bbs.service.category.VoteTicketCountService;
@Service
public class VoteTicketCountServiceImpl implements VoteTicketCountService{

    @Resource
    private VoteTicketCountRepository voteTicketCountRepository;

    @Resource
    private VoteTicketLogService voteTicketLogService;

    @Resource
    private MidUserCategoryVoteApplyService midUserCategoryVoteApplyService;

    @Resource
    private UserCategoryVoteSettingService userCategoryVoteSettingService;

    /**
     * 插入记录日志
     *
     * @param build
     * @return
     */
    @Override
    public int insert(VoteTicketCount build) {
        Long i = verifyByApplyId(build.getApplyId());
        if (i > 0) {
            return i.intValue();
        }
        return voteTicketCountRepository.insert(build);
    }


    private Long verifyByApplyId(Long applyId) {
        return voteTicketCountRepository.findCountByApplyId(applyId);

    }

    /**
     * 投票
     *
     * @param applyId
     * @param userId
     * @return
     */
    @Override
    public Boolean addVoteTicket(Long applyId, Long userId) {
        // 验证是否可以投票
        MidUserCategoryVoteApply midUserCategoryVoteApply = midUserCategoryVoteApplyService.verifyByApplyId(applyId);
        userCategoryVoteSettingService.verifyTicketTime(midUserCategoryVoteApply.getVoteSettingId());

        int i = voteTicketCountRepository.addVoteTicket(applyId);
        if (i > 0) {
            voteTicketLogService.insert(VoteTicketLog.builder()
                    .applyId(applyId)
                    .userId(userId)
                    .deleted(DeletedEnum.FALSE.getCode())
                    .build());
        }
        throw new NoceException("投票失败,请稍后重试");
    }

    @Override
    public List<VoteTicketCount> findTicketByApplyIds(List<Long> applyIdList) {
        return voteTicketCountRepository.findTicketByApplyIds(applyIdList);
    }
}
