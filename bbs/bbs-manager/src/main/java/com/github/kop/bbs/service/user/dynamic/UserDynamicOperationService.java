package com.github.kop.bbs.service.user.dynamic;

/** 用户动态操作：点赞、踩 */
public interface UserDynamicOperationService {

  boolean like(Long userId, Long id);

  boolean cancelLike(Long userId, Long id);

  boolean dislike(Long userId, Long id);

  boolean cancelDislike(Long userId, Long id);
}
