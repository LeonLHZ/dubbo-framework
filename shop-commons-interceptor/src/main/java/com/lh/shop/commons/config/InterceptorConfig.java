package com.lh.shop.commons.config;

import com.lh.shop.commons.interceptor.SsoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author Neo
 * @date 2020/5/10 14:44
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer
{

    @Autowired
    private SsoInterceptor ssoInterceptor;

    public InterceptorConfig()
    {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(ssoInterceptor).addPathPatterns("/**").excludePathPatterns("/static");

    }
}