package com.github.kop.bbs.service.tag;


import com.github.kop.bbs.module.req.tag.TagAddReq;
import com.github.kop.bbs.module.res.RespVO;

public interface TagService {

    /**
     * 添加标签
     * @param tagAddReq
     * @return
     */
    Boolean create(TagAddReq tagAddReq,Long userId);
}
