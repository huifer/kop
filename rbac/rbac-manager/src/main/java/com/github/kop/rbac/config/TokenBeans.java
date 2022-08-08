package com.github.kop.rbac.config;

import com.github.kop.rbac.utils.JwtTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TokenBeans {
    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil(30000, "laksjfij91j23k");
    }
}
