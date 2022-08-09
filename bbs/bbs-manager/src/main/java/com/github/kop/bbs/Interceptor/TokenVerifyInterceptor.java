package com.github.kop.bbs.Interceptor;

import com.github.kop.bbs.module.ex.NoceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/9 23:28
 */
@Slf4j
@Component
public class TokenVerifyInterceptor implements HandlerInterceptor {

    private static final String TOKEN_HEADER = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(TOKEN_HEADER);
        if(ObjectUtils.isEmpty(token)){
            throw new NoceException("token无效");
        }
        // TODO: 2022/8/9 校验token
        return true;
    }
}
