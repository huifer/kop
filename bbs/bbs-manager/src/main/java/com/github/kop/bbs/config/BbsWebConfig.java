package com.github.kop.bbs.config;

import com.github.kop.bbs.Interceptor.TokenVerifyInterceptor;
import com.github.kop.bbs.config.BbsConfiguration.BBSEnv;
import com.github.kop.bbs.config.BbsConfiguration.Url;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

import javax.annotation.Resource;

/**
 * @auth ahxiaoqi
 * @desc
 * @time 2022/8/9 23:23
 */
@Component
public class BbsWebConfig implements WebMvcConfigurer {

    @Resource
    private TokenVerifyInterceptor tokenVerifyInterceptor;


    @Autowired
    private BbsConfiguration bbsConfiguration;

    /**
     * 拦截器注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(
                tokenVerifyInterceptor)
            .addPathPatterns("/**");

        Url url = bbsConfiguration.getUrl();

        if (!CollectionUtils.isEmpty(url.getWhite())) {

            // 开放的请求路径
            interceptorRegistration.excludePathPatterns(url.getWhite());
        }

        if (BBSEnv.DEV == (bbsConfiguration.getEnv())) {

            interceptorRegistration
                // swagger
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/swagger-ui/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/doc.html");
        }

    }
}
