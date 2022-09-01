package com.github.kop.bbs.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.kop.bbs.module.entity.Message;
import com.github.kop.bbs.module.enums.message.MessageStatusEnum;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
  int updateBatchSelective(List<Message> list);

  int batchInsert(@Param("list") List<Message> list);

  @Update("update bbs_message set tips_status = #{read} where 1=1 and receiver_user_id = #{userId} ")
  boolean updateToRead(@Param("userId") Long userId, @Param("read") MessageStatusEnum read);
}
