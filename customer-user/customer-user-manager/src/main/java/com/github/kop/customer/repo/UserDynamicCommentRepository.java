package com.github.kop.customer.repo;

import com.github.kop.customer.module.entity.CustomerUserDynamic;
import com.github.kop.customer.module.entity.CustomerUserDynamicComment;

public interface UserDynamicCommentRepository {
    int  create(CustomerUserDynamicComment customerUserDynamicComment);
}
