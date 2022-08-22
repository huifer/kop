package com.github.kop.bbs.service.tag.impl;

import com.github.kop.bbs.module.entity.Tag;
import com.github.kop.bbs.module.req.topic.TopicCreateReq;
import com.github.kop.bbs.repo.TagRepository;
import com.github.kop.bbs.service.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

  @Autowired
  private TagRepository tagRepository;


}
