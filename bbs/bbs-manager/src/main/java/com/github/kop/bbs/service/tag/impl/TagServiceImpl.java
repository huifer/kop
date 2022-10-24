package com.github.kop.bbs.service.tag.impl;

import com.github.kop.bbs.module.entity.Tag;
import com.github.kop.bbs.module.ex.ValidateException;
import com.github.kop.bbs.module.req.tag.TagAddReq;
import com.github.kop.bbs.repo.TagRepository;
import com.github.kop.bbs.service.tag.TagService;
import com.github.kop.bbs.utils.CreateValidate;
import com.github.kop.bbs.utils.UpdateValidate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

  @Autowired private TagRepository tagRepository;

  protected final TagServiceImpl.TagAndUpdateValidate tagAndUpdateValidate =
      new TagServiceImpl.TagAndUpdateValidate();

  /**
   * 添加标签
   *
   * @param tagAddReq
   * @return
   */
  @Override
  public Boolean create(TagAddReq tagAddReq, Long userId) {
    boolean b = tagRepository.verifyName(tagAddReq.getTag());
    if (b) {
      return true;
    }
    return tagRepository.insert(
            Tag.builder().userId(userId).tag(tagAddReq.getTag()).quoteNum(0L).build())
        > 0;
  }

  protected class TagAndUpdateValidate
      implements CreateValidate<TagAddReq>, UpdateValidate<TagAddReq> {

    @Override
    public void createValidate(TagAddReq tagAddReq) throws ValidateException {
      if (ObjectUtils.isEmpty(tagAddReq.getTag())) {
        throw new ValidateException("标签不能为空!");
      }
    }

    @Override
    public void updateValidate(TagAddReq tagAddReq) throws ValidateException {}
  }
}
