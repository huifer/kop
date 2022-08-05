package com.github.kop.customer.service.impl;

import com.github.kop.customer.module.entity.CustomerUserDynamicComment;
import com.github.kop.customer.repo.UserDynamicCommentRepository;
import com.github.kop.customer.service.UserDynamicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserDynamicCommentServiceImpl implements UserDynamicCommentService {
    @Autowired
    private UserDynamicCommentRepository userDynamicCommentRepository;

    @Override
    public boolean create(Long userId, String msg, Long dynamicId, Long pid) {
        CustomerUserDynamicComment customerUserDynamicComment = new CustomerUserDynamicComment();
        customerUserDynamicComment.setCreateTime(LocalDateTime.now());
        customerUserDynamicComment.setDynamicId(dynamicId);
        customerUserDynamicComment.setUserId(userId);
        customerUserDynamicComment.setPid(pid);
        customerUserDynamicComment.setContent(msg);

        return userDynamicCommentRepository.create(customerUserDynamicComment) > 0;
    }

}
