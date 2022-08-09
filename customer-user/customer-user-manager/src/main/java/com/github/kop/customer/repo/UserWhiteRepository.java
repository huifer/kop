package com.github.kop.customer.repo;

import java.util.List;

public interface UserWhiteRepository {
  int create(long selfUserId, long opUserId);

  int delete(long selfUserId, long opUserId);

  List<Long> whiteIds(long userId);

  boolean exists(long curUserId, Long targetUserId);
}
