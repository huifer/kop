package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.kop.bbs.module.entity.Topic;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TopicMapper extends BaseMapper<Topic> {
  int updateBatchSelective(List<Topic> list);

  int batchInsert(@Param("list") List<Topic> list);

  IPage<Topic> selectOrderByHot(@Param("page") Long page, @Param("size") Long size, @Param("topicTitle") String topicTitle);
}
